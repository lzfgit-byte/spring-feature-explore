package com.ilzf.event.event.context;

import com.ilzf.util.LogUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * -protected void finishRefresh() {
 * -         this.clearResourceCaches();
 * -         this.initLifecycleProcessor();
 * -         this.getLifecycleProcessor().onRefresh();
 * -         this.publishEvent((ApplicationEvent)(new ContextRefreshedEvent(this)));
 * 启动生命周期完成refresh时调用。
 * 继承自 ApplicationContextEvent
 */
@Component
public class TestContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LogUtil.log("TestContextRefreshedEvent");
    }
}
