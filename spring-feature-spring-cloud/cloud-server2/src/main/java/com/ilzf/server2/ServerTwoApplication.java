package com.ilzf.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ServerTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class, args);
    }
}
