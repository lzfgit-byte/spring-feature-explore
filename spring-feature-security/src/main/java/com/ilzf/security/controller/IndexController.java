package com.ilzf.security.controller;

import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController("")
@Api("测试权限")
public class IndexController {

    @Autowired
    StringRedisTemplate redisTemplate;


    @ApiOperation("校验权限")
    @GetMapping("/api/getVal")
    public String getVal() {
        return "getVal";
    }

    @ApiOperation("登录接口")
    @GetMapping("/api/login")
    public String login(@ApiParam(value = "用户名", required = true) String name, @ApiParam(value = "密码", required = true) String password) {
        return "getVal";
    }

    @ApiOperation("向redis存值")
    @GetMapping("/")
    public String index() {
        redisTemplate.opsForValue().set("stringVal", "123456");
        redisTemplate.opsForHash().put("hashVal", "key", "value");
        redisTemplate.opsForHash().put("hashVal", "key2", "value2");
        redisTemplate.opsForHash().put("hashVal", "key3", "value3");
        redisTemplate.opsForList().leftPush("listVal", "1");
        redisTemplate.opsForList().leftPush("listVal", "2");
        redisTemplate.opsForList().leftPush("listVal", "3");
        redisTemplate.opsForSet().add("setVal", "1", "2", "3", "4", "5", "5");
        return "a";
    }

    @ApiOperation("从redis取值")
    @GetMapping("/index2")
    public String index2() {
        LogUtil.log(redisTemplate.opsForValue().get("stringVal"));
        Objects.requireNonNull(redisTemplate.opsForSet().members("setVal")).forEach(LogUtil::log);
        LogUtil.log(Objects.requireNonNull(redisTemplate.opsForHash().get("hashVal", "key3")).toString());
        LogUtil.log(redisTemplate.opsForList().leftPop("listVal"));
        return redisTemplate.opsForValue().get("stringVal");
    }
}
