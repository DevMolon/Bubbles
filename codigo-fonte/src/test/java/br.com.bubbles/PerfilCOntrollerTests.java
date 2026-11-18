
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class PerfilControllerTests {

    private JogadorRepository jogadorRepository;
    private ParticipacaoRepository participacaoRepository;
    private LigaService ligaService;
    private PerfilController perfilController;
    private HttpSession session;
    private Model model;

    @BeforeEach
    void configurar() {

        jogadorRepository = mock(JogadorRepository.class);
        participacaoRepository = mock(ParticipacaoRepository.class);

        ligaService = new LigaService();

        perfilController = new PerfilController(
                jogadorRepository,
                participacaoRepository,
                ligaService
        );

        session = mock(HttpSession.class);
        model = new ExtendedModelMap();
    }

    @Test
    void deveExibirPerfilQuandoJogadorEstiverAutenticado() {

        Jogador jogador = new Jogador();
        jogador.setId(1L);
        jogador.setNickname("Ana");
        jogador.setRating(500.0);

        when(session.getAttribute("jogadorId")).thenReturn(1L);
        when(jogadorRepository.findById(1L)).thenReturn(Optional.of(jogador));
        when(participacaoRepository
                .findByJogadorIdOrderByPartidaDataHoraDesc(1L))
                .thenReturn(List.of());

        String resultado = perfilController.exibirPerfil(session, model);

        assertEquals("perfil", resultado);
        assertEquals(jogador, model.getAttribute("jogador"));
        assertEquals("Ouro", model.getAttribute("liga"));
        assertTrue(((List<?>) model.getAttribute("historico")).isEmpty());

        verify(jogadorRepository).findById(1L);
        verify(participacaoRepository)
                .findByJogadorIdOrderByPartidaDataHoraDesc(1L);
    }

    @Test
    void deveRedirecionarQuandoJogadorNaoEstiverAutenticado() {

        when(session.getAttribute("jogadorId")).thenReturn(null);

        String resultado = perfilController.exibirPerfil(session, model);

        assertEquals("redirect:/login", resultado);

        verifyNoInteractions(jogadorRepository, participacaoRepository);
    }

    @Test
    void deveEncerrarSessaoQuandoJogadorNaoExistir() {

        when(session.getAttribute("jogadorId")).thenReturn(1L);
        when(jogadorRepository.findById(1L)).thenReturn(Optional.empty());

        String resultado = perfilController.exibirPerfil(session, model);

        assertEquals("redirect:/login", resultado);

        verify(session).invalidate();

        verifyNoInteractions(participacaoRepository);
    }
}
