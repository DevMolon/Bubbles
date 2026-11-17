
package br.com.bubbles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participacao")
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_jogador", nullable = false)
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "id_partida", nullable = false)
    private Partida partida;

    @Column(name = "cor_bolha", nullable = false, length = 20)
    private String corBolha;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultado", nullable = false, length = 10)
    private Resultado resultado;

    @Column(name = "rating_antes", nullable = false)
    private Double ratingAntes;

    @Column(name = "rating_depois", nullable = false)
    private Double ratingDepois;

    public Participacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public String getCorBolha() {
        return corBolha;
    }

    public void setCorBolha(String corBolha) {
        this.corBolha = corBolha;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Double getRatingAntes() {
        return ratingAntes;
    }

    public void setRatingAntes(Double ratingAntes) {
        this.ratingAntes = ratingAntes;
    }

    public Double getRatingDepois() {
        return ratingDepois;
    }

    public void setRatingDepois(Double ratingDepois) {
        this.ratingDepois = ratingDepois;
    }
}
