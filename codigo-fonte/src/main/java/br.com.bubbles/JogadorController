
package br.com.bubbles;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/cadastro")
    public String exibirCadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(
            @RequestParam String nickname,
            @RequestParam String senha,
            @RequestParam(required = false) String email,
            RedirectAttributes redirectAttributes) {

        try {
            jogadorService.cadastrar(nickname, senha, email);

            redirectAttributes.addFlashAttribute(
                    "sucesso",
                    "Cadastro realizado com sucesso! Faça seu login."
            );

            return "redirect:/login";

        } catch (IllegalArgumentException e) {

            redirectAttributes.addFlashAttribute(
                    "erro",
                    e.getMessage()
            );

            return "redirect:/cadastro";
        }
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticar(
            @RequestParam String nickname,
            @RequestParam String senha,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Optional<Jogador> jogador =
                jogadorService.autenticar(nickname, senha);

        if (jogador.isPresent()) {

            session.setAttribute("jogadorId", jogador.get().getId());
            session.setAttribute("nickname", jogador.get().getNickname());

            return "redirect:/inicio";
        }

        redirectAttributes.addFlashAttribute(
                "erro",
                "Nickname ou senha incorretos."
        );

        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String sair(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
