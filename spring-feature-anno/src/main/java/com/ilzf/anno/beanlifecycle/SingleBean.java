package com.ilzf.anno.beanlifecycle;

import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SingleBean implements DisposableBean, InitializingBean {
    /**
     * 每次都会执行
     */
    @PostConstruct
    public void say() {
        LogUtil.log("SingleBean 被创建了");
    }

    /**
     * spring bean 的bean是多例下的PreDestroy 不会执行
     */
    @PreDestroy
    public void say2() {
        LogUtil.log("SingleBean 被销毁了");
    }

    /**
     * spring bean 的bean是多例下的 不会执行
     */
    @Override
    public void destroy() throws Exception {
        LogUtil.log("SingleBean 被销毁了 destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.log("SingleBean 被创建了 afterPropertiesSet");
    }
}
