package com.ilzf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextAware
 * 创建bean的时候如果 类型是ApplicationContextAware
 * 会执行setApplicationContext 方法
 */
@Component
public class ApplicationHolder implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationHolder.context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return ApplicationHolder.context;
    }
}
