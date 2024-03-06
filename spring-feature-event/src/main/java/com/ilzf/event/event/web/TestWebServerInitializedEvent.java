package com.ilzf.event.event.web;

import com.ilzf.util.LogUtil;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * org.springframework.boot.web.servlet.context.WebServerStartStopLifecycle
 * -public void start() {
 * -      this.webServer.start();
 * -      this.running = true;
 * -      this.applicationContext.publishEvent(new ServletWebServerInitializedEvent(this.webServer, this.applicationContext));
 * -}
 * <p>
 * servlet 启动后直接掉
 * ServletWebServerInitializedEvent 继承自 WebServerInitializedEvent
 * 所以会被事件系统感知到，事件直接被转成父级了
 * - public void publishEvent(ApplicationEvent event) {
 * -       this.publishEvent(event, (ResolvableType)null);
 * -  }
 */
public class TestWebServerInitializedEvent implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        LogUtil.log("TestWebServerInitializedEvent");
    }
}
