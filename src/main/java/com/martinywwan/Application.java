package com.martinywwan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        int exitCode = SpringApplication.exit(SpringApplication.run(Application.class));
        System.exit(exitCode);
    }
}
