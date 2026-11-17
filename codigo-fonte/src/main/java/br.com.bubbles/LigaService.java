
package br.com.bubbles;

import org.springframework.stereotype.Service;

@Service
public class LigaService {

    public String calcularLiga(double rating) {

        if (rating < 100) {
            return "Sem classificação";
        }

        if (rating < 200) {
            return "Bronze";
        }

        if (rating < 350) {
            return "Prata";
        }

        if (rating < 550) {
            return "Ouro";
        }

        if (rating < 800) {
            return "Platina";
        }

        return "Diamante";
    }
}
