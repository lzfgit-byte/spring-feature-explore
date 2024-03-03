package com.ilzf.anno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AnnoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnoApplication.class, args);
        System.out.println("http://localhost:8080");
        System.out.println("http://localhost:8080/doc.html");
    }
}
