
package br.com.bubbles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartidaPersistenciaService {

    private final PartidaRepository partidaRepository;
    private final ParticipacaoRepository participacaoRepository;
    private final JogadorRepository jogadorRepository;
    private final GlickoService glickoService;

    public PartidaPersistenciaService(
            PartidaRepository partidaRepository,
            ParticipacaoRepository participacaoRepository,
            JogadorRepository jogadorRepository,
            GlickoService glickoService) {

        this.partidaRepository = partidaRepository;
        this.participacaoRepository = participacaoRepository;
        this.jogadorRepository = jogadorRepository;
        this.glickoService = glickoService;
    }

    @Transactional
    public Partida registrarPartida(
            Jogador jogadorAzul,
            Jogador jogadorRosa,
            Resultado resultadoAzul) {

        // Validar os jogadores
        if (jogadorAzul == null || jogadorRosa == null) {
            throw new IllegalArgumentException(
                    "Os dois jogadores são obrigatórios.");
        }

        if (jogadorAzul.getId() == null ||
            jogadorRosa.getId() == null ||
            Objects.equals(jogadorAzul.getId(), jogadorRosa.getId())) {

            throw new IllegalArgumentException(
                    "A partida exige dois jogadores cadastrados e distintos.");
        }

        // Validar o resultado
        if (resultadoAzul == null) {
            throw new IllegalArgumentException(
                    "O resultado da partida é obrigatório.");
        }

        // Determinar o resultado do jogador rosa
        Resultado resultadoRosa;

        switch (resultadoAzul) {
            case VITORIA:
                resultadoRosa = Resultado.DERROTA;
                break;

            case DERROTA:
                resultadoRosa = Resultado.VITORIA;
                break;

            case EMPATE:
                resultadoRosa = Resultado.EMPATE;
                break;

            default:
                throw new IllegalArgumentException(
                        "Resultado inválido.");
        }

        // Corrigir ratings negativos antigos
        if (jogadorAzul.getRating() < 0) {
            jogadorAzul.setRating(0.0);
        }

        if (jogadorRosa.getRating() < 0) {
            jogadorRosa.setRating(0.0);
        }

        // Guardar os ratings anteriores dos dois jogadores
        double ratingAzulAntes = jogadorAzul.getRating();
        double rdAzulAntes = jogadorAzul.getRd();

        double ratingRosaAntes = jogadorRosa.getRating();
        double rdRosaAntes = jogadorRosa.getRd();

        // Calcular o novo rating do jogador azul
        GlickoService.RatingAtualizado atualizacaoAzul =
                glickoService.calcularRating(
                        ratingAzulAntes,
                        rdAzulAntes,
                        ratingRosaAntes,
                        rdRosaAntes,
                        resultadoAzul);

        // Calcular o novo rating do jogador rosa
        GlickoService.RatingAtualizado atualizacaoRosa =
                glickoService.calcularRating(
                        ratingRosaAntes,
                        rdRosaAntes,
                        ratingAzulAntes,
                        rdAzulAntes,
                        resultadoRosa);

        // Obter os novos valores
        double ratingAzulDepois = atualizacaoAzul.getRating();
        double rdAzulDepois = atualizacaoAzul.getRd();

        double ratingRosaDepois = atualizacaoRosa.getRating();
        double rdRosaDepois = atualizacaoRosa.getRd();

        LocalDateTime agora = LocalDateTime.now();

        // Atualizar o jogador azul
        jogadorAzul.setRating(ratingAzulDepois);
        jogadorAzul.setRd(rdAzulDepois);
        jogadorAzul.setUltimaAtualizacaoRating(agora);

        // Atualizar o jogador rosa
        jogadorRosa.setRating(ratingRosaDepois);
        jogadorRosa.setRd(rdRosaDepois);
        jogadorRosa.setUltimaAtualizacaoRating(agora);

        // Salvar os jogadores atualizados
        jogadorRepository.saveAll(
                List.of(jogadorAzul, jogadorRosa));

        // Criar e salvar a partida
        Partida partida = new Partida();
        partida.setDataHora(agora);

        partida = partidaRepository.save(partida);

        // Registrar participação do jogador azul
        Participacao participacaoAzul = new Participacao();

        participacaoAzul.setJogador(jogadorAzul);
        participacaoAzul.setPartida(partida);
        participacaoAzul.setCorBolha("AZUL");
        participacaoAzul.setResultado(resultadoAzul);
        participacaoAzul.setRatingAntes(ratingAzulAntes);
        participacaoAzul.setRatingDepois(ratingAzulDepois);

        // Registrar participação do jogador rosa
        Participacao participacaoRosa = new Participacao();

        participacaoRosa.setJogador(jogadorRosa);
        participacaoRosa.setPartida(partida);
        participacaoRosa.setCorBolha("ROSA");
        participacaoRosa.setResultado(resultadoRosa);
        participacaoRosa.setRatingAntes(ratingRosaAntes);
        participacaoRosa.setRatingDepois(ratingRosaDepois);

        // Salvar as duas participações
        participacaoRepository.saveAll(
                List.of(participacaoAzul, participacaoRosa));

        return partida;
    }
}
