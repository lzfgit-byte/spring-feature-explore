package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationStartingEvent implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LogUtil.log("TestApplicationStartingEvent");
    }
}
