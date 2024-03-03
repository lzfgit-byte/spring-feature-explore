package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ILzfApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LogUtil.log("ApplicationStartedEvent");
    }
}
