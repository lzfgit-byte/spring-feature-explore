package com.ilzf.security.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@Api("测试权限")
public class IndexController {

    @Autowired
    StringRedisTemplate redisTemplate;


    @GetMapping("/")
    public String index() {
        redisTemplate.opsForValue().set("test", "123456");
        return "a";
    }
}
