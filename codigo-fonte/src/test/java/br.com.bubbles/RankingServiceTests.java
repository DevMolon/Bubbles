
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

public class RankingServiceTests {

    private JogadorRepository jogadorRepository;
    private RankingService rankingService;

    @BeforeEach
    void configurar() {
        jogadorRepository = mock(JogadorRepository.class);
        rankingService = new RankingService(jogadorRepository);
    }

    @Test
    void deveConsultarRankingOrdenado() {

        Jogador jogador1 = new Jogador();
        jogador1.setNickname("Ana");
        jogador1.setRating(Double.valueOf(500.0));

        Jogador jogador2 = new Jogador();
        jogador2.setNickname("Carlos");
        jogador2.setRating(Double.valueOf(300.0));

        when(jogadorRepository.findAll(any(Sort.class)))
                .thenReturn(List.of(jogador1, jogador2));

        List<Jogador> ranking = rankingService.consultarRanking();

        assertEquals(2, ranking.size());
        assertEquals("Ana", ranking.get(0).getNickname());
        assertEquals("Carlos", ranking.get(1).getNickname());

        verify(jogadorRepository, times(1))
                .findAll(any(Sort.class));
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoExistiremJogadores() {

        when(jogadorRepository.findAll(any(Sort.class)))
                .thenReturn(List.of());

        List<Jogador> ranking = rankingService.consultarRanking();

        assertNotNull(ranking);
        assertTrue(ranking.isEmpty());

        verify(jogadorRepository, times(1))
                .findAll(any(Sort.class));
    }
}
