
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartidaServiceTests {

    private PartidaService partidaService;

    @BeforeEach
    void configurar() {
        partidaService = new PartidaService();
    }

    @Test
    void deveAlternarJogadores() {
        assertEquals("AZUL", partidaService.getJogadorAtual());

        assertTrue(partidaService.realizarJogada(0, 0));

        assertEquals("ROSA", partidaService.getJogadorAtual());
    }

    @Test
    void deveIdentificarVitoriaAzul() {
        partidaService.realizarJogada(0, 0);
        partidaService.realizarJogada(1, 0);
        partidaService.realizarJogada(0, 1);
        partidaService.realizarJogada(1, 1);
        partidaService.realizarJogada(0, 2);

        assertEquals("VITORIA_AZUL", partidaService.getResultado());
    }

    @Test
    void naoDevePermitirJogadaEmPosicaoOcupada() {
        assertTrue(partidaService.realizarJogada(0, 0));

        assertFalse(partidaService.realizarJogada(0, 0));

        assertEquals(1, partidaService.getJogadas());
    }

    @Test
    void deveIdentificarEmpate() {
        partidaService.realizarJogada(0, 0);
        partidaService.realizarJogada(0, 1);
        partidaService.realizarJogada(0, 2);
        partidaService.realizarJogada(1, 1);
        partidaService.realizarJogada(1, 0);
        partidaService.realizarJogada(1, 2);
        partidaService.realizarJogada(2, 1);
        partidaService.realizarJogada(2, 0);
        partidaService.realizarJogada(2, 2);

        assertEquals("EMPATE", partidaService.getResultado());
    }

    @Test
    void deveReiniciarPartida() {
        partidaService.realizarJogada(0, 0);
        partidaService.reiniciarPartida();

        assertEquals("AZUL", partidaService.getJogadorAtual());
        assertEquals("EM_ANDAMENTO", partidaService.getResultado());
        assertEquals(0, partidaService.getJogadas());
        assertNull(partidaService.getTabuleiro()[0][0]);
    }
}
