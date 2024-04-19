package com.ilzf.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootConfiguration
@EnableWebMvc
public class MybatisExploreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisExploreApplication.class,args);
    }
}
