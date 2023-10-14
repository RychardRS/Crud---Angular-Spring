package com.esigtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// import springfox.documentation.oas.annotations.EnableOpenApi;

// @EnableSwagger2 // Para o Swagger 2
// @EnableOpenApi // Para o Swagger 3 (OpenAPI 3)
@SpringBootApplication
@EntityScan(basePackages = "com.esigtest.model")
@ComponentScan(basePackages= {"com.esigtest.*"})
@EnableJpaRepositories(basePackages = {"com.esigtest.repository"})
@EnableTransactionManagement
public class EsigTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsigTestApplication.class, args);
    }
}

