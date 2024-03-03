package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor
 */
public class ILzfBeanPostProcessor implements BeanPostProcessor {
    /**
     * postProcessBeforeInitialization
     * 方法会在bean实例化和属性设置之后，自定义初始化方法之前被调用，
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 返回的Object 会被Spring 当成这个bean的实例，而替换到生成的
     * 而postProcessAfterInitialization方法会在自定义初始化方法之后被调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("iLzfService".equals(beanName)) {
            LogUtil.log("ILzfService BeanPostProcessor");
            //拦截了 BeanPostProcessor
//            return new ILzfService("BeanPostProcessor");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
