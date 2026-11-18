
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class RankingControllerTests {

    private RankingService rankingService;
    private LigaService ligaService;
    private RankingController rankingController;
    private HttpSession session;
    private Model model;

    @BeforeEach
    void configurar() {
        rankingService = mock(RankingService.class);
        ligaService = new LigaService();
        rankingController = new RankingController(
                rankingService, ligaService);

        session = mock(HttpSession.class);
        model = new ExtendedModelMap();
    }

    @Test
    void deveExibirRankingQuandoJogadorEstiverAutenticado() {

        Jogador jogador = new Jogador();
        jogador.setNickname("Ana");
        jogador.setRating(500.0);

        when(session.getAttribute("jogadorId"))
                .thenReturn(1L);

        when(rankingService.consultarRanking())
                .thenReturn(List.of(jogador));

        String resultado = rankingController.exibirRanking(
                session, model);

        assertEquals("ranking", resultado);
        assertEquals(List.of(jogador), model.getAttribute("jogadores"));
        assertEquals(ligaService, model.getAttribute("ligaService"));

        verify(rankingService).consultarRanking();
    }

    @Test
    void deveRedirecionarParaLoginQuandoNaoEstiverAutenticado() {

        when(session.getAttribute("jogadorId"))
                .thenReturn(null);

        String resultado = rankingController.exibirRanking(
                session, model);

        assertEquals("redirect:/login", resultado);

        verify(rankingService, never()).consultarRanking();
    }

    @Test
    void deveExibirRankingVazioQuandoNaoExistiremJogadores() {

        when(session.getAttribute("jogadorId"))
                .thenReturn(1L);

        when(rankingService.consultarRanking())
                .thenReturn(List.of());

        String resultado = rankingController.exibirRanking(
                session, model);

        assertEquals("ranking", resultado);
        assertTrue(((List<?>) model.getAttribute("jogadores")).isEmpty());
    }
}
