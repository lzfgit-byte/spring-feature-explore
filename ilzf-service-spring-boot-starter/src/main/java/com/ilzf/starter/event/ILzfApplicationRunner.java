package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class ILzfApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogUtil.log("ApplicationRunner");
    }
}
