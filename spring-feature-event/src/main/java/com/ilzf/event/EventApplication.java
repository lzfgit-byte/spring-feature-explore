package com.ilzf.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class);
        //触发事件
//        SpringApplication app = new SpringApplicationBuilder(EventApplication.class).listeners().build();
//        app.run(args);
    }
}
