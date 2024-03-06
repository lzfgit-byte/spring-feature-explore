package com.ilzf.event.event.application;


import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 在run方法，准备context   上下文初始化刚刚开始 ApplicationPreparedEvent才是初始化成功
 * -  context = this.createApplicationContext();
 * -  context.setApplicationStartup(this.applicationStartup);
 * -  this.prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
 * <p>
 * <p>
 * <p>
 * -    private void prepareContext(DefaultBootstrapContext bootstrapContext, ConfigurableApplicationContext context, ConfigurableEnvironment environment, SpringApplicationRunListeners listeners, ApplicationArguments applicationArguments, Banner printedBanner) {
 * -        context.setEnvironment(environment);
 * -        this.postProcessApplicationContext(context);
 * -        this.applyInitializers(context);
 * -        listeners.contextPrepared(context);
 * <p>
 * 会触发ApplicationContextInitializedEvent
 */
@Component
public class TestApplicationContextInitializedEvent implements ApplicationListener<ApplicationContextInitializedEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        LogUtil.log("TestApplicationContextInitializedEvent");
    }
}
