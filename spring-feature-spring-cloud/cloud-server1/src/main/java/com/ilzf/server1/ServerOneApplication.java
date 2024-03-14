package com.ilzf.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
//@EnableDiscoveryClient
public class ServerOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerOneApplication.class, args);
    }
}
