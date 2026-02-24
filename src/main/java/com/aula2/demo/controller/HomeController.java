package com.aula2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller simples que redireciona a página inicial (/) para a lista de alunos.
 * Assim, ao acessar http://localhost:8080, o usuário já é levado para o cadastro.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String redirecionarParaAlunos() {
        return "redirect:/alunos";
    }
}
