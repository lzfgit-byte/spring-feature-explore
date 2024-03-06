package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * -try {
 * -          Duration timeTakenToReady = Duration.ofNanos(System.nanoTime() - startTime);
 * -          listeners.ready(context, timeTakenToReady);
 * -          return context;
 * <p>
 * this.callRunners(context, applicationArguments);之后运行，
 * 从此之后，启动的所有事项已经处理完毕，
 * 万籁俱寂
 */
@Component
public class TestApplicationReadyEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LogUtil.log("TestApplicationReadyEvent");
    }
}
