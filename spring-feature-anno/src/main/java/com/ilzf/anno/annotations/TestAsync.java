package com.ilzf.anno.annotations;


import com.ilzf.util.LogUtil;
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

    @Async()
    public CompletableFuture<String> say() {
        LogUtil.log("TestAsync...");
        return CompletableFuture.completedFuture("TestAsync");
    }

    @Async
    public CompletableFuture<String> say2() {
        LogUtil.log("TestAsync...2");
        return CompletableFuture.completedFuture("TestAsync");
    }
}
