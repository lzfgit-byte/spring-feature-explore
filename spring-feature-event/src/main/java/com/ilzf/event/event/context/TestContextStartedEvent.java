package com.ilzf.event.event.context;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * 启动时无调用
 */
@Component
public class TestContextStartedEvent implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        LogUtil.log("TestContextStartedEvent");
    }
}
