package com.aula2.demo.service;

import com.aula2.demo.model.dto.ChuckNorrisResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ChuckNorrisService {
    RestTemplate restTemplate = new RestTemplate();

    public ChuckNorrisResponse getRandomJoke(){
        return restTemplate.getForObject("https://api.chucknorris.io/jokes/random", ChuckNorrisResponse.class);
    }
}

