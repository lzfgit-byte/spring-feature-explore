package com.ilzf.starter.config;

import com.ilzf.starter.properties.ILzfServerProperties;
import com.ilzf.starter.service.ILzfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ILzfService.class)
@EnableConfigurationProperties(ILzfServerProperties.class)//注册该类同级的bean，让spring自动扫描
public class ILzfEnableAutoConfig {
    @Autowired
    ILzfServerProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "ilzf.show", value = "enable", havingValue = "true")
    public ILzfService iLzfService() {

        return new ILzfService(properties.getName());
    }
}
