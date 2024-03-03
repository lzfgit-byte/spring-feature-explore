package com.ilzf.starter.event;

import com.ilzf.util.LogUtil;

import javax.annotation.PostConstruct;

public class ILzfPostConstruct {

    @PostConstruct
    public void say() {
        LogUtil.log("PostConstruct");
    }
}
