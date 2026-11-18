
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LigaServiceTests {

    private LigaService ligaService;

    @BeforeEach
    void configurar() {
        ligaService = new LigaService();
    }

    @Test
    void deveClassificarBronze() {
        assertEquals("Bronze", ligaService.calcularLiga(150));
    }

    @Test
    void deveClassificarPrata() {
        assertEquals("Prata", ligaService.calcularLiga(250));
    }

    @Test
    void deveClassificarOuro() {
        assertEquals("Ouro", ligaService.calcularLiga(400));
    }

    @Test
    void deveClassificarPlatina() {
        assertEquals("Platina", ligaService.calcularLiga(600));
    }

    @Test
    void deveClassificarDiamante() {
        assertEquals("Diamante", ligaService.calcularLiga(900));
    }

    @Test
    void deveRetornarSemClassificacaoAbaixoDeCem() {
        assertEquals("Sem classificação", ligaService.calcularLiga(50));
    }
}
