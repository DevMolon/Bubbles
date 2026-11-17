
package br.com.bubbles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    Optional<Jogador> findByNickname(String nickname);

    boolean existsByNickname(String nickname);
}
