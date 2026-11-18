
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

public class JogadorControllerTests {

    private JogadorService jogadorService;
    private JogadorController jogadorController;

    @BeforeEach
    void configurar() {
        jogadorService = mock(JogadorService.class);
        jogadorController = new JogadorController(jogadorService);
    }

    @Test
    void deveExibirPaginaDeCadastro() {
        assertEquals("cadastro", jogadorController.exibirCadastro());
    }

    @Test
    void deveExibirPaginaDeLogin() {
        assertEquals("login", jogadorController.exibirLogin());
    }

    @Test
    void deveCadastrarJogadorComSucesso() {

        RedirectAttributes atributos = new RedirectAttributesModelMap();

        when(jogadorService.cadastrar("Ana", "senha123", "ana@email.com"))
                .thenReturn(new Jogador());

        String resultado = jogadorController.cadastrar(
                "Ana", "senha123", "ana@email.com", atributos);

        assertEquals("redirect:/login", resultado);
        assertEquals("Cadastro realizado com sucesso! Faça seu login.",
                atributos.getFlashAttributes().get("sucesso"));
    }

    @Test
    void deveRetornarErroQuandoCadastroFalhar() {

        RedirectAttributes atributos = new RedirectAttributesModelMap();

        when(jogadorService.cadastrar("Ana", "123", null))
                .thenThrow(new IllegalArgumentException("Senha inválida."));

        String resultado = jogadorController.cadastrar(
                "Ana", "123", null, atributos);

        assertEquals("redirect:/cadastro", resultado);
        assertEquals("Senha inválida.",
                atributos.getFlashAttributes().get("erro"));
    }

    @Test
    void deveAutenticarJogadorComSucesso() {

        Jogador jogador = new Jogador();
        jogador.setId(1L);
        jogador.setNickname("Ana");

        when(jogadorService.autenticar("Ana", "senha123"))
                .thenReturn(Optional.of(jogador));

        HttpSession session = mock(HttpSession.class);
        RedirectAttributes atributos = new RedirectAttributesModelMap();

        String resultado = jogadorController.autenticar(
                "Ana", "senha123", session, atributos);

        assertEquals("redirect:/inicio", resultado);

        verify(session).setAttribute("jogadorId", 1L);
        verify(session).setAttribute("nickname", "Ana");
    }

    @Test
    void deveRecusarLoginIncorreto() {

        when(jogadorService.autenticar("Ana", "senhaerrada"))
                .thenReturn(Optional.empty());

        HttpSession session = mock(HttpSession.class);
        RedirectAttributes atributos = new RedirectAttributesModelMap();

        String resultado = jogadorController.autenticar(
                "Ana", "senhaerrada", session, atributos);

        assertEquals("redirect:/login", resultado);

        assertEquals("Nickname ou senha incorretos.",
                atributos.getFlashAttributes().get("erro"));

        verify(session, never()).setAttribute(anyString(), any());
    }

    @Test
    void deveEncerrarSessao() {

        HttpSession session = mock(HttpSession.class);

        String resultado = jogadorController.sair(session);

        assertEquals("redirect:/login", resultado);
        verify(session).invalidate();
    }
}
