package com.ilzf.event.event.other;

import com.ilzf.util.LogUtil;
import org.springframework.boot.BootstrapContextClosedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 在当前容器的父级关闭时
 */
@Component
public class TestBootstrapContextClosedEvent implements ApplicationListener<BootstrapContextClosedEvent> {
    @Override
    public void onApplicationEvent(BootstrapContextClosedEvent event) {
        LogUtil.log("TestBootstrapContextClosedEvent");
    }
}
