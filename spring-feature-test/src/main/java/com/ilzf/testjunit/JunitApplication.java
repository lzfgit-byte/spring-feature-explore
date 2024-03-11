package com.ilzf.testjunit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class JunitApplication {
    public static void main(String[] args) {
        SpringApplication.run(JunitApplication.class);
    }
}
