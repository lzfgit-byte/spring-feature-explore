package com.ilzf.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("ilzf.show")
@Component
@Data
public class ILzfServerProperties {
    private String name;
}
