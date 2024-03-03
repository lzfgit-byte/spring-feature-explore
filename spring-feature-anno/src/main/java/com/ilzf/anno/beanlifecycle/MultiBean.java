package com.ilzf.anno.beanlifecycle;

import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 单例bean的情况下，一下都执行
 * <p>
 * <p>
 * 多例bean
 * singleton prototype request session global session
 */
@Component
@Scope("prototype")
public class MultiBean implements DisposableBean, InitializingBean {
    /**
     * 每次都会执行
     */
    @PostConstruct
    public void say() {
        LogUtil.log("MultiBean 被创建了");
    }

    /**
     * spring bean 的bean是多例下的PreDestroy 不会执行
     */
    @PreDestroy
    public void say2() {
        LogUtil.log("MultiBean 被销毁了");
    }

    /**
     * spring bean 的bean是多例下的 不会执行
     */
    @Override
    public void destroy() throws Exception {
        LogUtil.log("MultiBean 被销毁了 destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.log("MultiBean 被创建了 afterPropertiesSet");
    }
}
