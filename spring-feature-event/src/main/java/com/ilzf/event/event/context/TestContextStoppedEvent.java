package com.ilzf.event.event.context;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 不会执行，会执行closed事件
 */
@Component
public class TestContextStoppedEvent implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        LogUtil.log("TestContextStoppedEvent");
    }
}
