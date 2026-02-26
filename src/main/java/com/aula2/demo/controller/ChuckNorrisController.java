package com.aula2.demo.controller;

import com.aula2.demo.service.ChuckNorrisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class ChuckNorrisController {

    private final ChuckNorrisService service;

    @GetMapping("/chuck")
    public String getJoke() {
        return service.getRandomJoke().getValue();
    }
}