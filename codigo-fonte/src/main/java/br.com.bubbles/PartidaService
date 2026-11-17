
package br.com.bubbles;

public class PartidaService {

    private static final int TAMANHO = 3;

    private final String[][] tabuleiro = new String[TAMANHO][TAMANHO];

    private String jogadorAtual = "AZUL";

    private String resultado = "EM_ANDAMENTO";

    private int jogadas = 0;

    public boolean realizarJogada(int linha, int coluna) {

        // Impede jogadas após o encerramento da partida
        if (!resultado.equals("EM_ANDAMENTO")) {
            return false;
        }

        // Verifica se a posição está dentro do tabuleiro
        if (linha < 0 || linha >= TAMANHO ||
            coluna < 0 || coluna >= TAMANHO) {
            return false;
        }

        // Impede jogar em uma posição ocupada
        if (tabuleiro[linha][coluna] != null) {
            return false;
        }

        // Registra a jogada
        tabuleiro[linha][coluna] = jogadorAtual;
        jogadas++;

        // Verifica se o jogador venceu
        if (verificarVitoria(jogadorAtual)) {

            resultado = jogadorAtual.equals("AZUL")
                    ? "VITORIA_AZUL"
                    : "VITORIA_ROSA";

        } else if (jogadas == 9) {

            // Verifica se houve empate
            resultado = "EMPATE";

        } else {

            // Alterna entre os jogadores
            jogadorAtual = jogadorAtual.equals("AZUL")
                    ? "ROSA"
                    : "AZUL";
        }

        return true;
    }

    private boolean verificarVitoria(String cor) {

        // Verificar linhas
        for (int linha = 0; linha < TAMANHO; linha++) {

            if (cor.equals(tabuleiro[linha][0]) &&
                cor.equals(tabuleiro[linha][1]) &&
                cor.equals(tabuleiro[linha][2])) {

                return true;
            }
        }

        // Verificar colunas
        for (int coluna = 0; coluna < TAMANHO; coluna++) {

            if (cor.equals(tabuleiro[0][coluna]) &&
                cor.equals(tabuleiro[1][coluna]) &&
                cor.equals(tabuleiro[2][coluna])) {

                return true;
            }
        }

        // Verificar diagonal principal
        if (cor.equals(tabuleiro[0][0]) &&
            cor.equals(tabuleiro[1][1]) &&
            cor.equals(tabuleiro[2][2])) {

            return true;
        }

        // Verificar diagonal secundária
        if (cor.equals(tabuleiro[0][2]) &&
            cor.equals(tabuleiro[1][1]) &&
            cor.equals(tabuleiro[2][0])) {

            return true;
        }

        return false;
    }

    public void reiniciarPartida() {

        // Limpa todas as posições do tabuleiro
        for (int linha = 0; linha < TAMANHO; linha++) {

            for (int coluna = 0; coluna < TAMANHO; coluna++) {

                tabuleiro[linha][coluna] = null;
            }
        }

        jogadorAtual = "AZUL";
        resultado = "EM_ANDAMENTO";
        jogadas = 0;
    }

    public String[][] getTabuleiro() {

        // Retorna uma cópia do tabuleiro
        String[][] copia = new String[TAMANHO][TAMANHO];

        for (int linha = 0; linha < TAMANHO; linha++) {

            for (int coluna = 0; coluna < TAMANHO; coluna++) {

                copia[linha][coluna] = tabuleiro[linha][coluna];
            }
        }

        return copia;
    }

    public String getJogadorAtual() {
        return jogadorAtual;
    }

    public String getResultado() {
        return resultado;
    }

    public int getJogadas() {
        return jogadas;
    }
}
