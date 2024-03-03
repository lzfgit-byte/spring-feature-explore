package com.ilzf.util.config;

import com.ilzf.util.ApplicationHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ILzfUtilConfig {
    @Bean
    public ApplicationHolder applicationHolder() {
        return new ApplicationHolder();
    }
}
