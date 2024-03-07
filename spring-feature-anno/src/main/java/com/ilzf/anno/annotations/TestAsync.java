package com.ilzf.anno.annotations;


import com.ilzf.util.LogUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 会异步执行，但是需要在启动类注解
 * <p>
 * EnableAsync 来开起异步
 * 而且方法返回值会一律变为null
 */
@Component
public class TestAsync {

    @Async
    public String say() {
        LogUtil.log("TestAsync...");
        return "TestAsync";
    }
}
