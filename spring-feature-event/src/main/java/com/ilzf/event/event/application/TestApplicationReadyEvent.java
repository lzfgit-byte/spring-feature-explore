package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationReadyEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LogUtil.log("TestApplicationReadyEvent");
    }
}
