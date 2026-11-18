
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InicioControllerTests {

    private InicioController inicioController;
    private HttpSession session;

    @BeforeEach
    void configurar() {
        inicioController = new InicioController();
        session = mock(HttpSession.class);
    }

    @Test
    void deveExibirInicioQuandoJogadorEstiverAutenticado() {

        when(session.getAttribute("jogadorId"))
                .thenReturn(1L);

        String resultado = inicioController.exibirInicio(session);

        assertEquals("inicio", resultado);
    }

    @Test
    void deveRedirecionarParaLoginQuandoNaoEstiverAutenticado() {

        when(session.getAttribute("jogadorId"))
                .thenReturn(null);

        String resultado = inicioController.exibirInicio(session);

        assertEquals("redirect:/login", resultado);
    }
}
