
package br.com.bubbles;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    private final JogadorRepository jogadorRepository;
    private final ParticipacaoRepository participacaoRepository;
    private final LigaService ligaService;

    public PerfilController(
            JogadorRepository jogadorRepository,
            ParticipacaoRepository participacaoRepository,
            LigaService ligaService) {

        this.jogadorRepository = jogadorRepository;
        this.participacaoRepository = participacaoRepository;
        this.ligaService = ligaService;
    }

    @GetMapping("/perfil")
    public String exibirPerfil(HttpSession session, Model model) {

        Object idSessao = session.getAttribute("jogadorId");

        if (!(idSessao instanceof Long)) {
            return "redirect:/login";
        }

        Long jogadorId = (Long) idSessao;

        Jogador jogador = jogadorRepository.findById(jogadorId)
                .orElse(null);

        if (jogador == null) {
            session.invalidate();
            return "redirect:/login";
        }

        model.addAttribute("jogador", jogador);

        model.addAttribute(
                "liga",
                ligaService.calcularLiga(jogador.getRating())
        );

        model.addAttribute(
                "historico",
                participacaoRepository
                        .findByJogadorIdOrderByPartidaDataHoraDesc(jogadorId)
        );

        return "perfil";
    }
}
