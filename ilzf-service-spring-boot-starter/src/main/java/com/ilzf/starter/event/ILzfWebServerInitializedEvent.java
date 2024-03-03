package com.ilzf.starter.event;


import com.ilzf.util.LogUtil;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

public class ILzfWebServerInitializedEvent implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        LogUtil.log("WebServerInitializedEvent");
        int serverPort = event.getWebServer().getPort();
    }
}
