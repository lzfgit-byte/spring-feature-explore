package com.ilzf.util.config;

import com.ilzf.util.ApplicationContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ILzfUtilConfig {
    @Bean
    public ApplicationContextHolder applicationHolder() {
        return new ApplicationContextHolder();
    }
}
