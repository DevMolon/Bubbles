
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GlickoServiceTests {

    private GlickoService glickoService;

    @BeforeEach
    void configurar() {
        glickoService = new GlickoService();
    }

    @Test
    void vitoriaDeveAumentarRating() {

        GlickoService.RatingAtualizado resultado =
                glickoService.calcularRating(
                        100.0, 350.0,
                        100.0, 350.0,
                        Resultado.VITORIA);

        assertTrue(resultado.getRating() > 100.0);
    }

    @Test
    void derrotaDeveDiminuirRating() {

        GlickoService.RatingAtualizado resultado =
                glickoService.calcularRating(
                        100.0, 350.0,
                        100.0, 350.0,
                        Resultado.DERROTA);

        assertTrue(resultado.getRating() < 100.0);
    }

    @Test
    void empateEntreJogadoresComMesmoRatingDeveManterRating() {

        GlickoService.RatingAtualizado resultado =
                glickoService.calcularRating(
                        100.0, 350.0,
                        100.0, 350.0,
                        Resultado.EMPATE);

        assertEquals(100.0, resultado.getRating(), 0.000001);
    }

    @Test
    void rdDeveDiminuirAposUmaPartida() {

        GlickoService.RatingAtualizado resultado =
                glickoService.calcularRating(
                        100.0, 350.0,
                        100.0, 350.0,
                        Resultado.VITORIA);

        assertTrue(resultado.getRd() < 350.0);
    }

    @Test
    void rdDeveRespeitarLimiteMinimo() {

        GlickoService.RatingAtualizado resultado =
                glickoService.calcularRating(
                        100.0, 30.0,
                        100.0, 30.0,
                        Resultado.VITORIA);

        assertTrue(resultado.getRd() >= 30.0);
    }

    @Test
    void naoDeveAceitarResultadoNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                glickoService.calcularRating(
                        100.0, 350.0,
                        100.0, 350.0,
                        null));
    }
}
