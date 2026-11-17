
package br.com.bubbles;

import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PartidaController {

    private static final String CHAVE_PARTIDA = "partidaAtual";
    private static final String CHAVE_ADVERSARIO = "adversarioId";
    private static final String CHAVE_REGISTRO = "partidaRegistrada";

    private final JogadorRepository jogadorRepository;
    private final JogadorService jogadorService;
    private final PartidaPersistenciaService persistenciaService;

    public PartidaController(
            JogadorRepository jogadorRepository,
            JogadorService jogadorService,
            PartidaPersistenciaService persistenciaService) {

        this.jogadorRepository = jogadorRepository;
        this.jogadorService = jogadorService;
        this.persistenciaService = persistenciaService;
    }

    @GetMapping("/jogo")
    public String exibirJogo(HttpSession session, Model model) {

        Object idSessao = session.getAttribute("jogadorId");

        if (!(idSessao instanceof Long)) {
            return "redirect:/login";
        }

        Long jogadorAzulId = (Long) idSessao;

        Jogador jogadorAzul = jogadorRepository.findById(jogadorAzulId)
                .orElseThrow(() ->
                        new IllegalStateException("Jogador azul não encontrado."));

        model.addAttribute("jogadorAzul", jogadorAzul);

        Object adversarioSessao = session.getAttribute(CHAVE_ADVERSARIO);

        if (adversarioSessao instanceof Long) {

            Long jogadorRosaId = (Long) adversarioSessao;

            Jogador jogadorRosa = jogadorRepository.findById(jogadorRosaId)
                    .orElse(null);

            if (jogadorRosa != null) {
                model.addAttribute("jogadorRosa", jogadorRosa);
                model.addAttribute("segundoJogadorAutenticado", true);
            } else {
                session.removeAttribute(CHAVE_ADVERSARIO);
                model.addAttribute("segundoJogadorAutenticado", false);
            }

        } else {
            model.addAttribute("segundoJogadorAutenticado", false);
        }

        PartidaService partida =
                (PartidaService) session.getAttribute(CHAVE_PARTIDA);

        if (partida == null) {
            partida = new PartidaService();
            session.setAttribute(CHAVE_PARTIDA, partida);
        }

        model.addAttribute("tabuleiro", partida.getTabuleiro());
        model.addAttribute("jogadorAtual", partida.getJogadorAtual());
        model.addAttribute("resultado", partida.getResultado());

        return "jogo";
    }

    @PostMapping("/jogo/segundo-login")
    public String autenticarSegundoJogador(
            @RequestParam String nickname,
            @RequestParam String senha,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Object idSessao = session.getAttribute("jogadorId");

        if (!(idSessao instanceof Long)) {
            return "redirect:/login";
        }

        if (nickname == null || nickname.trim().isEmpty()
                || senha == null || senha.isEmpty()) {

            redirectAttributes.addFlashAttribute(
                    "erro", "Informe o nickname e a senha do segundo jogador.");

            return "redirect:/jogo";
        }

        var jogadorAutenticado = jogadorService.autenticar(nickname, senha);

        if (jogadorAutenticado.isEmpty()) {

            redirectAttributes.addFlashAttribute(
                    "erro", "Nickname ou senha do segundo jogador incorretos.");

            return "redirect:/jogo";
        }

        Jogador jogadorRosa = jogadorAutenticado.get();

        if (jogadorRosa.getId().equals((Long) idSessao)) {

            redirectAttributes.addFlashAttribute(
                    "erro", "O segundo jogador precisa usar outra conta.");

            return "redirect:/jogo";
        }

        session.setAttribute(CHAVE_ADVERSARIO, jogadorRosa.getId());
        session.setAttribute(CHAVE_PARTIDA, new PartidaService());
        session.removeAttribute(CHAVE_REGISTRO);

        redirectAttributes.addFlashAttribute(
                "sucesso", "Segundo jogador autenticado! A partida pode começar.");

        return "redirect:/jogo";
    }

    @PostMapping("/jogo/iniciar")
    public String iniciarPartida(
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (!(session.getAttribute("jogadorId") instanceof Long)) {
            return "redirect:/login";
        }

        if (!(session.getAttribute(CHAVE_ADVERSARIO) instanceof Long)) {

            redirectAttributes.addFlashAttribute(
                    "erro", "O segundo jogador precisa entrar na própria conta.");

            return "redirect:/jogo";
        }

        session.setAttribute(CHAVE_PARTIDA, new PartidaService());
        session.removeAttribute(CHAVE_REGISTRO);

        return "redirect:/jogo";
    }

    /*
     * NOVO ENDPOINT:
     * Recebe jogadas pelo JavaScript sem recarregar a página.
     */
    @PostMapping("/jogo/jogada-ajax")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> realizarJogadaAjax(
            @RequestParam int linha,
            @RequestParam int coluna,
            HttpSession session) {

        Object idSessao = session.getAttribute("jogadorId");

        if (!(idSessao instanceof Long)) {
            return criarResposta(
                    HttpStatus.UNAUTHORIZED,
                    false,
                    "Sua sessão expirou. Entre novamente.",
                    null);
        }

        Object adversarioSessao = session.getAttribute(CHAVE_ADVERSARIO);

        if (!(adversarioSessao instanceof Long)) {
            return criarResposta(
                    HttpStatus.FORBIDDEN,
                    false,
                    "O segundo jogador precisa autenticar sua conta.",
                    null);
        }

        PartidaService partida =
                (PartidaService) session.getAttribute(CHAVE_PARTIDA);

        if (partida == null) {
            return criarResposta(
                    HttpStatus.CONFLICT,
                    false,
                    "Não existe uma partida ativa. Inicie uma nova partida.",
                    null);
        }

        synchronized (partida) {

            boolean jogadaValida = partida.realizarJogada(linha, coluna);

            if (!jogadaValida) {
                return criarResposta(
                        HttpStatus.BAD_REQUEST,
                        false,
                        "Jogada inválida! Escolha outra posição.",
                        partida);
            }

            String resultado = partida.getResultado();

            if (!"EM_ANDAMENTO".equals(resultado)
                    && !Boolean.TRUE.equals(
                            session.getAttribute(CHAVE_REGISTRO))) {

                Long jogadorAzulId = (Long) idSessao;
                Long jogadorRosaId = (Long) adversarioSessao;

                Jogador jogadorAzul = jogadorRepository.findById(jogadorAzulId)
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "Jogador azul não encontrado."));

                Jogador jogadorRosa = jogadorRepository.findById(jogadorRosaId)
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "Jogador rosa não encontrado."));

                Resultado resultadoAzul;

                switch (resultado) {

                    case "VITORIA_AZUL":
                        resultadoAzul = Resultado.VITORIA;
                        break;

                    case "VITORIA_ROSA":
                        resultadoAzul = Resultado.DERROTA;
                        break;

                    case "EMPATE":
                        resultadoAzul = Resultado.EMPATE;
                        break;

                    default:
                        throw new IllegalStateException(
                                "Resultado de partida inválido.");
                }

                persistenciaService.registrarPartida(
                        jogadorAzul,
                        jogadorRosa,
                        resultadoAzul);

                session.setAttribute(CHAVE_REGISTRO, true);
            }

            String mensagem;

            switch (resultado) {

                case "VITORIA_AZUL":
                    mensagem = "Azul venceu!";
                    break;

                case "VITORIA_ROSA":
                    mensagem = "Rosa venceu!";
                    break;

                case "EMPATE":
                    mensagem = "Deu empate!";
                    break;

                default:
                    mensagem = "Vez de " + partida.getJogadorAtual() + "!";
            }

            return criarResposta(
                    HttpStatus.OK,
                    true,
                    mensagem,
                    partida);
        }
    }

    /*
     * Monta a resposta que será recebida pelo JavaScript.
     */
    private ResponseEntity<Map<String, Object>> criarResposta(
            HttpStatus status,
            boolean sucesso,
            String mensagem,
            PartidaService partida) {

        Map<String, Object> resposta = new LinkedHashMap<>();

        resposta.put("sucesso", sucesso);
        resposta.put("mensagem", mensagem);

        if (partida != null) {
            resposta.put("tabuleiro", partida.getTabuleiro());
            resposta.put("jogadorAtual", partida.getJogadorAtual());
            resposta.put("resultado", partida.getResultado());
            resposta.put("jogadas", partida.getJogadas());
        }

        return ResponseEntity.status(status).body(resposta);
    }

    /*
     * ROTA TRADICIONAL MANTIDA.
     * Continua disponível como alternativa ao AJAX.
     */
    @PostMapping("/jogo/jogada")
    public String realizarJogada(
            @RequestParam int linha,
            @RequestParam int coluna,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Object idSessao = session.getAttribute("jogadorId");

        if (!(idSessao instanceof Long)) {
            return "redirect:/login";
        }

        if (!(session.getAttribute(CHAVE_ADVERSARIO) instanceof Long)) {

            redirectAttributes.addFlashAttribute(
                    "erro", "O segundo jogador precisa autenticar sua conta.");

            return "redirect:/jogo";
        }

        PartidaService partida =
                (PartidaService) session.getAttribute(CHAVE_PARTIDA);

        if (partida == null) {
            return "redirect:/jogo";
        }

        boolean jogadaValida = partida.realizarJogada(linha, coluna);

        if (!jogadaValida) {

            redirectAttributes.addFlashAttribute(
                    "erro", "Jogada inválida! Escolha outra posição.");

            return "redirect:/jogo";
        }

        if (!"EM_ANDAMENTO".equals(partida.getResultado())
                && !Boolean.TRUE.equals(session.getAttribute(CHAVE_REGISTRO))) {

            Long jogadorAzulId = (Long) idSessao;
            Long jogadorRosaId = (Long) session.getAttribute(CHAVE_ADVERSARIO);

            Jogador jogadorAzul = jogadorRepository.findById(jogadorAzulId)
                    .orElseThrow(() ->
                            new IllegalStateException("Jogador azul não encontrado."));

            Jogador jogadorRosa = jogadorRepository.findById(jogadorRosaId)
                    .orElseThrow(() ->
                            new IllegalStateException("Jogador rosa não encontrado."));

            Resultado resultadoAzul;

            switch (partida.getResultado()) {
                case "VITORIA_AZUL":
                    resultadoAzul = Resultado.VITORIA;
                    break;

                case "VITORIA_ROSA":
                    resultadoAzul = Resultado.DERROTA;
                    break;

                case "EMPATE":
                    resultadoAzul = Resultado.EMPATE;
                    break;

                default:
                    throw new IllegalStateException("Resultado de partida inválido.");
            }

            persistenciaService.registrarPartida(
                    jogadorAzul, jogadorRosa, resultadoAzul);

            session.setAttribute(CHAVE_REGISTRO, true);
        }

        return "redirect:/jogo";
    }

    @PostMapping("/jogo/segundo-logout")
    public String desconectarSegundoJogador(
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        if (!(session.getAttribute("jogadorId") instanceof Long)) {
            return "redirect:/login";
        }

        session.removeAttribute(CHAVE_ADVERSARIO);

        session.setAttribute(CHAVE_PARTIDA, new PartidaService());

        session.removeAttribute(CHAVE_REGISTRO);

        redirectAttributes.addFlashAttribute(
                "sucesso",
                "Segundo jogador desconectado. Aguarde o próximo participante.");

        return "redirect:/jogo";
    }

    @PostMapping("/jogo/reiniciar")
    public String reiniciarPartida(HttpSession session) {

        if (!(session.getAttribute("jogadorId") instanceof Long)) {
            return "redirect:/login";
        }

        session.setAttribute(CHAVE_PARTIDA, new PartidaService());
        session.removeAttribute(CHAVE_REGISTRO);

        return "redirect:/jogo";
    }
}
