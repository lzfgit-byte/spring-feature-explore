package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * try {
 * -    ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
 * -    ConfigurableEnvironment environment = this.prepareEnvironment(listeners, bootstrapContext, applicationArguments);
 * <p>
 * <p>
 * listener 传入 prepareEnvironment 方法
 * <p>
 * -   private ConfigurableEnvironment prepareEnvironment(SpringApplicationRunListeners listeners, DefaultBootstrapContext bootstrapContext, ApplicationArguments applicationArguments) {
 * -       ConfigurableEnvironment environment = this.getOrCreateEnvironment();
 * -       this.configureEnvironment((ConfigurableEnvironment)environment, applicationArguments.getSourceArgs());
 * -       ConfigurationPropertySources.attach((Environment)environment);
 * --       listeners.environmentPrepared(bootstrapContext, (ConfigurableEnvironment)environment);
 */
@Component
public class TestApplicationEnvironmentPreparedEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        LogUtil.log("TestApplicationEnvironmentPreparedEvent");
    }
}
