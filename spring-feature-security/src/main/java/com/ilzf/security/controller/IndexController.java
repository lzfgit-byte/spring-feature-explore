package com.ilzf.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@Api("测试权限")
public class IndexController {
    @GetMapping("/")
    public String index() {
        
        return "a";
    }
}
