package com.ilzf.event.event.application;

import com.ilzf.util.LogUtil;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 标记 context初始化成功，
 * 初始化了 baner
 * 给beanFactory设置了环境变量
 * 设置了是否允许setAllowCircularReferences
 * 注册了 addBeanFactoryPostProcessor
 * <p>
 * -     prepareContext 方法里
 * -     this.load(context, sources.toArray(new Object[0]));
 * -     listeners.contextLoaded(context);
 */
@Component
public class TestApplicationPreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LogUtil.log("TestApplicationPreparedEvent");
    }
}
