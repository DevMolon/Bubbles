
package br.com.bubbles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RankingController {

    private final RankingService rankingService;

    private final LigaService ligaService;

    public RankingController(
            RankingService rankingService,
            LigaService ligaService) {
        this.rankingService = rankingService;
        this.ligaService = ligaService;
    }

    @GetMapping("/ranking")
    public String exibirRanking(HttpSession session, Model model) {

        if (session.getAttribute("jogadorId") == null) {
            return "redirect:/login";
        }

        model.addAttribute("jogadores", rankingService.consultarRanking());
        model.addAttribute("ligaService", ligaService);

        return "ranking";
    }
}
