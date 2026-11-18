
package br.com.bubbles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class JogadorServiceTests {

    @Mock
    private JogadorRepository jogadorRepository;

    private JogadorService jogadorService;

    @BeforeEach
    void configurar() {
        jogadorService = new JogadorService(jogadorRepository);
    }

    @Test
    void deveCadastrarJogadorComSenhaProtegida() {

        when(jogadorRepository.existsByNickname("Kai"))
                .thenReturn(false);

        when(jogadorRepository.save(any(Jogador.class)))
                .thenAnswer(invocacao -> invocacao.getArgument(0));

        Jogador jogador = jogadorService.cadastrar(
                "Kai", "senha1234", "kai@email.com");

        assertEquals("Kai", jogador.getNickname());

        assertNotEquals("senha1234", jogador.getSenhaHash());

        assertTrue(new BCryptPasswordEncoder()
                .matches("senha1234", jogador.getSenhaHash()));

        assertEquals(100.0, jogador.getRating());

        verify(jogadorRepository).save(any(Jogador.class));
    }

    @Test
    void naoDeveCadastrarNicknameDuplicado() {

        when(jogadorRepository.existsByNickname("Kai"))
                .thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                jogadorService.cadastrar("Kai", "senha1234", null));

        verify(jogadorRepository, never()).save(any(Jogador.class));
    }

    @Test
    void deveAutenticarComSenhaCorreta() {

        Jogador jogador = new Jogador();
        jogador.setNickname("Kai");
        jogador.setSenhaHash(
                new BCryptPasswordEncoder().encode("senha1234"));

        when(jogadorRepository.findByNickname("Kai"))
                .thenReturn(Optional.of(jogador));

        Optional<Jogador> resultado =
                jogadorService.autenticar("Kai", "senha1234");

        assertTrue(resultado.isPresent());
    }

    @Test
    void naoDeveAutenticarComSenhaIncorreta() {

        Jogador jogador = new Jogador();
        jogador.setNickname("Kai");
        jogador.setSenhaHash(
                new BCryptPasswordEncoder().encode("senha1234"));

        when(jogadorRepository.findByNickname("Kai"))
                .thenReturn(Optional.of(jogador));

        Optional<Jogador> resultado =
                jogadorService.autenticar("Kai", "senhaerrada");

        assertTrue(resultado.isEmpty());
    }
}
