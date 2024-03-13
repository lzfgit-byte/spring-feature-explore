package com.ilzf.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class PoiApplication {

    public static void main(String[] args) {
        // 启动Spring应用
        SpringApplication.run(PoiApplication.class, args);
    }
}
