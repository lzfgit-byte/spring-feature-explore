package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * - listeners.started(context, timeTakenToStartup);
 * - this.callRunners(context, applicationArguments);
 * 启动完成后第一时间通知，不算在启动时间里
 */
@Component
public class TestApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LogUtil.log("TestApplicationStartedEvent");
    }
}
