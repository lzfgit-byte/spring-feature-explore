package com.ilzf.anno.config;

import com.ilzf.util.LogUtil;

import java.util.concurrent.Executor;

public class MyAsyncExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        LogUtil.log("AsyncExecutor");
    }
}
