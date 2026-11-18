
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

class PartidaControllerTests {

    private PartidaController controller;
    private JogadorRepository jogadorRepository;
    private JogadorService jogadorService;
    private PartidaPersistenciaService persistenciaService;
    private MockHttpSession session;

    @BeforeEach
    void preparar() {

        jogadorRepository = mock(JogadorRepository.class);
        jogadorService = mock(JogadorService.class);
        persistenciaService = mock(PartidaPersistenciaService.class);

        controller = new PartidaController(
                jogadorRepository,
                jogadorService,
                persistenciaService);

        session = new MockHttpSession();
    }

    private Jogador criarJogador(Long id, String nickname) {

        Jogador jogador = new Jogador();
        jogador.setId(id);
        jogador.setNickname(nickname);

        return jogador;
    }

    @Test
    void deveRedirecionarParaLoginQuandoNaoAutenticado() {

        String resultado = controller.exibirJogo(
                session, new ExtendedModelMap());

        assertEquals("redirect:/login", resultado);
    }

    @Test
    void deveExibirJogoEIdentificarJogadorAzul() {

        session.setAttribute("jogadorId", 1L);

        Jogador azul = criarJogador(1L, "DevMolon");

        when(jogadorRepository.findById(1L))
                .thenReturn(Optional.of(azul));

        ExtendedModelMap model = new ExtendedModelMap();

        String resultado = controller.exibirJogo(session, model);

        assertEquals("jogo", resultado);
        assertNotNull(session.getAttribute("partidaAtual"));
        assertNotNull(model.get("tabuleiro"));
        assertEquals("AZUL", model.get("jogadorAtual"));
        assertEquals("EM_ANDAMENTO", model.get("resultado"));
        assertEquals("DevMolon",
                ((Jogador) model.get("jogadorAzul")).getNickname());
        assertEquals(false, model.get("segundoJogadorAutenticado"));
    }

    @Test
    void deveAutenticarSegundoJogadorComCredenciaisValidas() {

        session.setAttribute("jogadorId", 1L);

        Jogador rosa = criarJogador(2L, "BubblesPlayer");

        when(jogadorService.autenticar("BubblesPlayer", "Senha123"))
                .thenReturn(Optional.of(rosa));

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.autenticarSegundoJogador(
                "BubblesPlayer", "Senha123", session, atributos);

        assertEquals("redirect:/jogo", resultado);
        assertEquals(2L, session.getAttribute("adversarioId"));
        assertNotNull(session.getAttribute("partidaAtual"));
        assertEquals(
                "Segundo jogador autenticado! A partida pode começar.",
                atributos.getFlashAttributes().get("sucesso"));
    }

    @Test
    void naoDeveAutenticarSegundoJogadorComSenhaIncorreta() {

        session.setAttribute("jogadorId", 1L);

        when(jogadorService.autenticar("BubblesPlayer", "SenhaErrada"))
                .thenReturn(Optional.empty());

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.autenticarSegundoJogador(
                "BubblesPlayer", "SenhaErrada", session, atributos);

        assertEquals("redirect:/jogo", resultado);
        assertNull(session.getAttribute("adversarioId"));
        assertEquals(
                "Nickname ou senha do segundo jogador incorretos.",
                atributos.getFlashAttributes().get("erro"));
    }

    @Test
    void naoDevePermitirQueOJogadorEntreNaPropriaContaComoRosa() {

        session.setAttribute("jogadorId", 1L);

        Jogador azul = criarJogador(1L, "DevMolon");

        when(jogadorService.autenticar("DevMolon", "Senha123"))
                .thenReturn(Optional.of(azul));

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.autenticarSegundoJogador(
                "DevMolon", "Senha123", session, atributos);

        assertEquals("redirect:/jogo", resultado);
        assertNull(session.getAttribute("adversarioId"));
        assertEquals(
                "O segundo jogador precisa usar outra conta.",
                atributos.getFlashAttributes().get("erro"));
    }

    @Test
    void naoDeveAutenticarSegundoJogadorSemPrimeiroLogin() {

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.autenticarSegundoJogador(
                "BubblesPlayer", "Senha123", session, atributos);

        assertEquals("redirect:/login", resultado);

        verify(jogadorService, never())
                .autenticar(anyString(), anyString());
    }

    @Test
    void deveImpedirInicioDaPartidaSemSegundoJogadorAutenticado() {

        session.setAttribute("jogadorId", 1L);

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.iniciarPartida(
                session, atributos);

        assertEquals("redirect:/jogo", resultado);
        assertEquals(
                "O segundo jogador precisa entrar na própria conta.",
                atributos.getFlashAttributes().get("erro"));
    }

    @Test
    void deveIniciarPartidaComDoisJogadoresAutenticados() {

        session.setAttribute("jogadorId", 1L);
        session.setAttribute("adversarioId", 2L);

        String resultado = controller.iniciarPartida(
                session, new RedirectAttributesModelMap());

        assertEquals("redirect:/jogo", resultado);
        assertNotNull(session.getAttribute("partidaAtual"));
    }

    @Test
    void deveExigirSegundoJogadorAntesDeRealizarJogada() {

        session.setAttribute("jogadorId", 1L);

        RedirectAttributesModelMap atributos =
                new RedirectAttributesModelMap();

        String resultado = controller.realizarJogada(
                0, 0, session, atributos);

        assertEquals("redirect:/jogo", resultado);
        assertEquals(
                "O segundo jogador precisa autenticar sua conta.",
                atributos.getFlashAttributes().get("erro"));
    }

    @Test
    void deveReiniciarPartidaSemDesconectarSegundoJogador() {

        session.setAttribute("jogadorId", 1L);
        session.setAttribute("adversarioId", 2L);

        PartidaService partidaAntiga = new PartidaService();
        partidaAntiga.realizarJogada(0, 0);

        session.setAttribute("partidaAtual", partidaAntiga);

        String resultado = controller.reiniciarPartida(session);

        PartidaService novaPartida =
                (PartidaService) session.getAttribute("partidaAtual");

        assertEquals("redirect:/jogo", resultado);
        assertNotSame(partidaAntiga, novaPartida);
        assertEquals(0, novaPartida.getJogadas());
        assertEquals(2L, session.getAttribute("adversarioId"));
    }

    @Test
    void deveRedirecionarParaLoginAoReiniciarSemAutenticacao() {

        String resultado = controller.reiniciarPartida(session);

        assertEquals("redirect:/login", resultado);
    }
}
