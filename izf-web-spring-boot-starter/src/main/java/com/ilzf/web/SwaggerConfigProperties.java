package com.ilzf.web;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ilzf.swagger")
@ConditionalOnProperty("ilzf.swagger")
@Data
public class SwaggerConfigProperties {
    private String groupName;
    private String packagePath;
}
