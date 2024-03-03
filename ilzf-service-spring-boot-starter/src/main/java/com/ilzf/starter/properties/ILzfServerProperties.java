package com.ilzf.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ilzf.show")
@Data
public class ILzfServerProperties {
    private String name;
}
