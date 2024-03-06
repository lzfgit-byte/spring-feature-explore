package com.ilzf.event.event.context;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 上下文销毁时调用
 * 在preDestroy之前
 */
@Component
public class TestContextClosedEvent implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        LogUtil.log("TestContextClosedEvent");
    }
}
