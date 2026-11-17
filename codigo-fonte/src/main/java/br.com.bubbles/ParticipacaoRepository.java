
package br.com.bubbles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipacaoRepository extends JpaRepository<Participacao, Long> {

    List<Participacao> findByJogadorIdOrderByPartidaDataHoraDesc(Long jogadorId);

    List<Participacao> findByPartidaId(Long partidaId);
}
