package com.unip.tcc2k22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Tcc2k22Application {

    public static void main(String[] args) {
        SpringApplication.run(Tcc2k22Application.class, args);
    }

}
