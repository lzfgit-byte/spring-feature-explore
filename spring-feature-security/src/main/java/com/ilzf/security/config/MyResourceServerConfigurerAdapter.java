package com.ilzf.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

@Configuration
//@EnableResourceServer
@Component
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
}
