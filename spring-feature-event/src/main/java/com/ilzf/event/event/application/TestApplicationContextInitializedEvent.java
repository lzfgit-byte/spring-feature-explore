package com.ilzf.event.event.application;


import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class TestApplicationContextInitializedEvent implements ApplicationListener<ApplicationContextInitializedEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        LogUtil.log("TestApplicationContextInitializedEvent");
    }
}
