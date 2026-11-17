
package br.com.bubbles;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public Jogador cadastrar(String nickname, String senha, String email) {

        if (nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("O nickname é obrigatório.");
        }

        if (nickname.trim().length() > 30) {
            throw new IllegalArgumentException("O nickname deve ter no máximo 30 caracteres.");
        }

        if (senha == null || senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres.");
        }

        String nicknameNormalizado = nickname.trim();

        if (jogadorRepository.existsByNickname(nicknameNormalizado)) {
            throw new IllegalArgumentException("Este nickname já está cadastrado.");
        }

        Jogador jogador = new Jogador();
        jogador.setNickname(nicknameNormalizado);
        jogador.setSenhaHash(passwordEncoder.encode(senha));
        jogador.setEmail(email == null || email.trim().isEmpty() ? null : email.trim());

        jogador.setRating(100.0);
        jogador.setRd(350.0);

        jogador.setDataCadastro(java.time.LocalDateTime.now());

        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> autenticar(String nickname, String senha) {

        if (nickname == null || senha == null) {
            return Optional.empty();
        }

        return jogadorRepository.findByNickname(nickname.trim())
                .filter(jogador ->
                    passwordEncoder.matches(senha, jogador.getSenhaHash())
                );
    }

}

