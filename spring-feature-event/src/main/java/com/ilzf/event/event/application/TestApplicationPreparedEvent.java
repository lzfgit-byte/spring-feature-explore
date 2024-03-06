package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationPreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LogUtil.log("TestApplicationPreparedEvent");
    }
}
