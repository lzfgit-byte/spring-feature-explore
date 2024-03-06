package com.ilzf.anno.annotations;

import com.ilzf.util.LogUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 启动类添加 @EnableScheduling注解
 * 不会停止，一直运行
 * <p>
 * 有几个常用的工具类
 * MethodIntrospector
 * AopProxyUtils
 * <p>
 * org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor 实现 BeanPostProcessor接口
 * 在此处判断 postProcessAfterInitialization
 * 而且bean 不能是 AopInfrastructureBean TaskScheduler ScheduledExecutorService的实现
 * Class<?> targetClass = AopProxyUtils.ultimateTargetClass(bean); 获取bean的原始class
 * <p>
 * 解析两个注解 @Scheduled, @Schedules  获取Scheduled
 * //一个方法可以有多个Scheduled
 * Map<Method, Set<Scheduled>> annotatedMethods = MethodIntrospector.selectMethods(targetClass, (method)
 * <p>
 * <p>
 * 将获取到的bean里的信息进行注册  processScheduled
 * annotatedMethods.forEach((method, scheduledAnnotations) -> {
 * scheduledAnnotations.forEach((scheduled) -> {
 * this.processScheduled(scheduled, method, bean);
 * });
 * });
 * <p>
 * <p>
 * 在 processScheduled 里经过一系列的判断参数，创建不同的task  最后存在了 scheduledTasks 里
 * Set<ScheduledTask> regTasks = (Set)this.scheduledTasks.computeIfAbsent(bean, (key) -> {
 * return new LinkedHashSet(4);
 * });
 * regTasks.addAll(tasks);
 * <p>
 * <p>
 * 在开起logger的trace下会
 * if (this.logger.isTraceEnabled()) {
 * this.logger.trace("No @Scheduled annotations found on bean class: " + targetClass);
 * }
 */
@Component
public class ScheduledTest {

    @Scheduled(cron = "0/5 * * * * ?")
    public void say() {
        LogUtil.log("spring 的定时任务注解");
    }
}
