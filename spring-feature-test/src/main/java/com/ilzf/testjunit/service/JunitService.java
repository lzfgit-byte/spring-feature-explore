package com.ilzf.testjunit.service;

import com.ilzf.util.LogUtil;
import org.springframework.stereotype.Service;

@Service
public class JunitService {

    public boolean say() {
        LogUtil.log("say .. something....");
        return true;
    }
}
