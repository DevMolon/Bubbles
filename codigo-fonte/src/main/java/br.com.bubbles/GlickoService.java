
package br.com.bubbles;

import org.springframework.stereotype.Service;

@Service
public class GlickoService {

    // Constante matemática do sistema Glicko
    private static final double Q = Math.log(10) / 400.0;

    // Limites do Rating Deviation (RD)
    private static final double RD_MINIMO = 30.0;
    private static final double RD_MAXIMO = 350.0;

    /**
     * Calcula o novo rating e o novo RD de um jogador
     * após uma partida contra um adversário.
     */
    public RatingAtualizado calcularRating(
            double rating,
            double rd,
            double ratingOponente,
            double rdOponente,
            Resultado resultado) {

        // Validar os parâmetros
        if (resultado == null) {
            throw new IllegalArgumentException(
                    "O resultado da partida é obrigatório.");
        }

        if (!Double.isFinite(rating) ||
                !Double.isFinite(ratingOponente) ||
                !Double.isFinite(rd) ||
                !Double.isFinite(rdOponente) ||
                rating < 0 ||
                ratingOponente < 0 ||
                rd <= 0 ||
                rdOponente <= 0) {

            throw new IllegalArgumentException(
                    "Os valores de rating e RD são inválidos.");
        }

        // Converter o resultado em pontuação
        double pontuacao;

        switch (resultado) {
            case VITORIA:
                pontuacao = 1.0;
                break;

            case DERROTA:
                pontuacao = 0.0;
                break;

            case EMPATE:
                pontuacao = 0.5;
                break;

            default:
                throw new IllegalArgumentException(
                        "Resultado inválido.");
        }

        // Calcular a influência do RD do adversário
        double g = calcularG(rdOponente);

        // Calcular a expectativa de resultado
        double expectativa = 1.0 /
                (1.0 + Math.pow(
                        10.0,
                        -g * (rating - ratingOponente) / 400.0));

        // Calcular a variância da previsão
        double dQuadrado = 1.0 /
                (Q * Q * g * g *
                expectativa * (1.0 - expectativa));

        // Calcular o novo rating
        double novoRating = rating +
                (Q / (1.0 / (rd * rd) + 1.0 / dQuadrado))
                * g * (pontuacao - expectativa);

        // Garantir que o rating nunca fique abaixo de zero
        novoRating = Math.max(0.0, novoRating);

        // Calcular o novo RD
        double novoRD = Math.sqrt(
                1.0 / ((1.0 / (rd * rd)) +
                (1.0 / dQuadrado)));

        // Respeitar os limites do RD
        novoRD = Math.max(RD_MINIMO,
                Math.min(RD_MAXIMO, novoRD));

        return new RatingAtualizado(novoRating, novoRD);
    }

    /**
     * Calcula a função g do sistema Glicko.
     */
    private double calcularG(double rd) {
        return 1.0 / Math.sqrt(
                1.0 + (3.0 * Q * Q * rd * rd) /
                (Math.PI * Math.PI));
    }

    /**
     * Representa o resultado atualizado do cálculo.
     */
    public static class RatingAtualizado {

        private final double rating;
        private final double rd;

        public RatingAtualizado(double rating, double rd) {
            this.rating = rating;
            this.rd = rd;
        }

        public double getRating() {
            return rating;
        }

        public double getRd() {
            return rd;
        }
    }
}
