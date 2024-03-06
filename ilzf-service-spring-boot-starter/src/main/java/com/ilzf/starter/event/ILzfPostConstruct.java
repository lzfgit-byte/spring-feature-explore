package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ILzfPostConstruct {

    // Lifecycle method annotation requires a no-arg method

    /**
     * 反射工具类
     * ReflectionUtils.doWithLocalMethods(targetClass, (method) -> {
     * <p>
     * <p>
     * CommonAnnotationBeanPostProcessor 继承了 InitDestroyAnnotationBeanPostProcessor
     * org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
     * 在创建时会初始化下文的 Annotation
     * public CommonAnnotationBeanPostProcessor() {
     * this.setOrder(2147483644);
     * this.setInitAnnotationType(PostConstruct.class);
     * this.setDestroyAnnotationType(PreDestroy.class);
     * this.ignoreResourceType("javax.xml.ws.WebServiceContext");
     * if (jndiPresent) {
     * this.jndiFactory = new SimpleJndiBeanFactory();
     * }
     * }
     * <p>
     * <p>
     * org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor
     * buildLifecycleMetadata
     * 构建bean的元数据时，会遍历其方法
     * ReflectionUtils.doWithLocalMethods(targetClass, (method) -> {
     * if (this.initAnnotationType != null && method.isAnnotationPresent(this.initAnnotationType)) {
     * LifecycleElement element = new LifecycleElement(method);
     * currInitMethods.add(element);
     * 在这个执行的视乎initAnnotationType是PostConstruct。
     * <p>
     * if (!AnnotationUtils.isCandidateClass(clazz, Arrays.asList(this.initAnnotationType, this.destroyAnnotationType))) {
     * return this.emptyLifecycleMetadata;
     * } else {
     * <p>
     * <p>
     * 由org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor
     * 的方法postProcessBeforeInitialization 调用
     * <p>
     * 当Bean被容器初始化之后，会调用@PostConstruct的注解方法。
     * bean的生命周期
     */
    @PostConstruct
    public void say() {
        LogUtil.log("starter   PostConstruct");
    }

    /**
     * 与PostConstruct在同一位置处理
     * if (!AnnotationUtils.isCandidateClass(clazz, Arrays.asList(this.initAnnotationType, this.destroyAnnotationType))) {
     * return this.emptyLifecycleMetadata;
     * } else {
     * <p>
     * destroyAnnotationType 即是 PreDestroy
     * <p>
     * 当Bean在容器销毁之前，调用被@PreDestroy注解的方法
     */
    @PreDestroy
    public void say2() {
        LogUtil.log("PreDestroy");
    }
}
