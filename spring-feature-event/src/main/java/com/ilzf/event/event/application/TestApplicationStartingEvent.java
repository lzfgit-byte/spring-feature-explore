package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 创建完listener的瞬间，便会触发该事件
 * listeners.starting(bootstrapContext, this.mainApplicationClass);
 * <p>
 * public ConfigurableApplicationContext run(String... args) {
 * _____long startTime = System.nanoTime();
 * _____DefaultBootstrapContext bootstrapContext = this.createBootstrapContext();
 * _____ConfigurableApplicationContext context = null;
 * _____this.configureHeadlessProperty();
 * _____SpringApplicationRunListeners listeners = this.getRunListeners(args);
 * _____【listeners.starting(bootstrapContext, this.mainApplicationClass);】
 */
@Component
public class TestApplicationStartingEvent implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LogUtil.log("TestApplicationStartingEvent");
    }
}
