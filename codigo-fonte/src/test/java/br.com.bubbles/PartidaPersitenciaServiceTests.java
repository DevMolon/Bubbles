
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PartidaPersistenciaServiceTests {

    @Mock
    private PartidaRepository partidaRepository;

    @Mock
    private ParticipacaoRepository participacaoRepository;

    @Mock
    private JogadorRepository jogadorRepository;

    @Mock
    private GlickoService glickoService;

    private PartidaPersistenciaService persistenciaService;

    @BeforeEach
    void configurar() {
        persistenciaService = new PartidaPersistenciaService(
                partidaRepository,
                participacaoRepository,
                jogadorRepository,
                glickoService);
    }

    private Jogador criarJogador(Long id, String nickname, double rating) {
        Jogador jogador = new Jogador();
        jogador.setId(id);
        jogador.setNickname(nickname);
        jogador.setRating(rating);
        jogador.setRd(350.0);
        return jogador;
    }

    @Test
    void deveRegistrarPartidaEAtualizarRatings() {

        Jogador azul = criarJogador(1L, "JogadorAzul", 100.0);
        Jogador rosa = criarJogador(2L, "JogadorRosa", 120.0);

        when(glickoService.calcularRating(
                anyDouble(), anyDouble(), anyDouble(), anyDouble(),
                eq(Resultado.VITORIA)))
                .thenReturn(new GlickoService.RatingAtualizado(110.0, 300.0));

        when(glickoService.calcularRating(
                anyDouble(), anyDouble(), anyDouble(), anyDouble(),
                eq(Resultado.DERROTA)))
                .thenReturn(new GlickoService.RatingAtualizado(110.0, 300.0));

        when(partidaRepository.save(any(Partida.class)))
                .thenAnswer(invocacao -> invocacao.getArgument(0));

        Partida partida = persistenciaService.registrarPartida(
                azul, rosa, Resultado.VITORIA);

        assertNotNull(partida);

        assertEquals(110.0, azul.getRating());
        assertEquals(110.0, rosa.getRating());

        assertEquals(300.0, azul.getRd());
        assertEquals(300.0, rosa.getRd());

        verify(glickoService, times(2)).calcularRating(
                anyDouble(), anyDouble(), anyDouble(), anyDouble(),
                any(Resultado.class));

        verify(jogadorRepository).saveAll(anyList());
        verify(partidaRepository).save(any(Partida.class));
        verify(participacaoRepository).saveAll(anyList());
    }

    @Test
    void naoDeveRegistrarPartidaComMesmoJogador() {

        Jogador jogador = criarJogador(1L, "Jogador", 100.0);

        assertThrows(IllegalArgumentException.class, () ->
                persistenciaService.registrarPartida(
                        jogador, jogador, Resultado.VITORIA));

        verify(partidaRepository, never()).save(any(Partida.class));
        verify(participacaoRepository, never()).saveAll(anyList());
        verify(jogadorRepository, never()).saveAll(anyList());
    }

    @Test
    void naoDeveRegistrarPartidaSemResultado() {

        Jogador azul = criarJogador(1L, "JogadorAzul", 100.0);
        Jogador rosa = criarJogador(2L, "JogadorRosa", 120.0);

        assertThrows(IllegalArgumentException.class, () ->
                persistenciaService.registrarPartida(
                        azul, rosa, null));

        verify(partidaRepository, never()).save(any(Partida.class));
        verify(jogadorRepository, never()).saveAll(anyList());
    }
}
