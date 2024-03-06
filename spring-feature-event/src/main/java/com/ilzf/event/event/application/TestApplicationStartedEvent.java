package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LogUtil.log("TestApplicationStartedEvent");
    }
}
