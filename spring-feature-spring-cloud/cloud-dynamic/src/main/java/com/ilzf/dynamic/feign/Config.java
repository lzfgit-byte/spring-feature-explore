package com.ilzf.dynamic.feign;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DynamicClient dynamicClient() {
        return new DynamicClient();
    }

    @Bean
    public DynamicFeignClientFactory<?> dynamicFeignClientFactory(ApplicationContext appContext) {
        LogUtil.log("DynamicFeignClientFactory");
        return new DynamicFeignClientFactory<>(appContext);
    }
}
