package com.aula2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * @SpringBootApplication combina três anotações:
 *   - @Configuration    → permite definir beans de configuração
 *   - @EnableAutoConfiguration → configura automaticamente o projeto com base nas dependências
 *   - @ComponentScan    → escaneia pacotes em busca de componentes (@Controller, @Service, @Repository, etc.)
 *
 * Ao executar esta classe, o Spring Boot:
 *   1. Inicia um servidor web embutido (Tomcat, por padrão)
 *   2. Configura o banco de dados H2 em memória
 *   3. Cria as tabelas com base nas entidades JPA
 *   4. Registra controllers, services e repositories automaticamente
 */
@SpringBootApplication
public class    DemoApplication {

    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(DemoApplication.class, args);
    }

}
