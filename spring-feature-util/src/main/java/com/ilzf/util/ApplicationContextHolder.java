package com.ilzf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAware
 * 创建bean的时候如果 类型是ApplicationContextAware
 * 会执行setApplicationContext 方法
 * <p>
 * EnvironmentAware  EmbeddedValueResolverAware   ResourceLoaderAware  ApplicationEventPublisherAware
 * MessageSourceAware   ApplicationStartupAware  ApplicationContextAware
 */
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return ApplicationContextHolder.context;
    }
}
