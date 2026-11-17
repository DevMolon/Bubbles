
package br.com.bubbles;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String exibirInicio(HttpSession session) {

        if (session.getAttribute("jogadorId") == null) {
            return "redirect:/login";
        }

        return "inicio";
    }
}
