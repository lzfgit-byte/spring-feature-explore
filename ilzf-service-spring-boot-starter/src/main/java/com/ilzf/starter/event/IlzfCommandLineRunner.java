package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;
import org.springframework.boot.CommandLineRunner;

public class IlzfCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        LogUtil.log("CommandLineRunner");
    }
}
