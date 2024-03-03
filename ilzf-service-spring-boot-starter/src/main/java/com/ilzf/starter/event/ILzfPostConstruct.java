package com.ilzf.starter.event;

import javax.annotation.PostConstruct;

public class ILzfPostConstruct {

    @PostConstruct
    public void say() {
        System.out.println("-----PostConstruct-------");
    }
}
