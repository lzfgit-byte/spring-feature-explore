package com.ilzf.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController("/")
@Api("测试权限")
public class IndexController {
    @GetMapping("/")
    public String index() {

        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
            jedis.get("");
        } catch (Exception e) {

        }
        return "a";
    }
}
