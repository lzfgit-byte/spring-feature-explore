package com.ilzf.anno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置异步执行的线程池
 */
@Configuration(proxyBeanMethods = false)
@EnableAsync //开启注解
public class ConfigAsyncPool {

    @Bean(ConstantFiledUtil.KMALL_THREAD_POOL)
    public ThreadPoolTaskExecutor FebsShiroThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(200);
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(30);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(ConstantFiledUtil.KMALL_THREAD_NAME_PREFIX);
        //设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        executor.setAwaitTerminationSeconds(60);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    @Bean(name = "asyncExecutor2")
    public MyAsyncExecutor asyncExecutor() {
        return new MyAsyncExecutor();
    }
}


class ConstantFiledUtil {
    public static final String AUTHORIZATION_TOKEN = "authorizationToken";
    /**
     * kmall线程池名称
     */
    public static final String KMALL_THREAD_POOL = "KmallThreadPool";

    /**
     * kmall线程名称前缀
     */
    public static final String KMALL_THREAD_NAME_PREFIX = "kmall-thread-";
}