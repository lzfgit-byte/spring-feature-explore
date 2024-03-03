package com.ilzf.anno.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod", name = "textBeanMethod_single")
    public TextBeanMethod textBeanMethod() {
        return new TextBeanMethod("单例");
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod", name = "textBeanMethod_multi")
    @Scope("prototype")
    public TextBeanMethod textBeanMethod2() {
        return new TextBeanMethod("多例");
    }
}
