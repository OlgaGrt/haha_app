package com.haha.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class
HahaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HahaAppApplication.class, args);
    }

}
