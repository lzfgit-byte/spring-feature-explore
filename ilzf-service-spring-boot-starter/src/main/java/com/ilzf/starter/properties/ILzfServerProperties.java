package com.ilzf.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties("ilzf.show")
//@PropertySource("classpath:application.yml")
@Data
public class ILzfServerProperties {
    private String name;
}
