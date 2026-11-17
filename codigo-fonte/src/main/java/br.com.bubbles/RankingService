
package br.com.bubbles;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    private final JogadorRepository jogadorRepository;

    public RankingService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> consultarRanking() {

        Sort ordenacao = Sort.by(
                Sort.Order.desc("rating"),
                Sort.Order.asc("nickname")
        );

        return jogadorRepository.findAll(ordenacao);
    }
}
