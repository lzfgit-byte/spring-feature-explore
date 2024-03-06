package com.ilzf.event.event.web;

import com.ilzf.util.LogUtil;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
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
 */
@Component
public class TestServletWebServerInitializedEvent implements ApplicationListener<ServletWebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        LogUtil.log("TestServletWebServerInitializedEvent");
    }
}
