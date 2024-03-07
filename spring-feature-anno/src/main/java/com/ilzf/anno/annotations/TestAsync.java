package com.ilzf.anno.annotations;


import com.ilzf.util.LogUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * 会异步执行，但是需要在启动类注解
 * <p>
 * EnableAsync 来开起异步，在 启动类 或是 配置类 上注解开起
 * 而且方法返回值会一律变为null
 */
@Component
public class TestAsync {


    @Async
    public CompletableFuture<String> say() {
        LogUtil.log("TestAsync...");
        return CompletableFuture.completedFuture("TestAsync");
    }

    /**
     * Async("asyncExecutor2")
     * 重定向到一个集成自java.util.concurrent.Executor的bean执行。
     * 但是会丢失异步性，会变为同步执行
     */
    @Async("asyncExecutor2")
    public CompletableFuture<String> say2() {
        LogUtil.log("TestAsync...2");
        return CompletableFuture.completedFuture("TestAsync2");
    }
}
