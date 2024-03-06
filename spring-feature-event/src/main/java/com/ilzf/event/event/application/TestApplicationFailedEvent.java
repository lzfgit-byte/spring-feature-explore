package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationFailedEvent implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        LogUtil.log("TestApplicationFailedEvent");
    }
}
