package com.rev.revisao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 * Responsável por iniciar a aplicação.
 */
@SpringBootApplication // Ativa a configuração automática e o escaneamento de componentes do Spring Boot
public class RevisaoApplication {

    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(RevisaoApplication.class, args);
    }

}