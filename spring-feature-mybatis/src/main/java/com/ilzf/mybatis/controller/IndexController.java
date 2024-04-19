package com.ilzf.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@Api(tags = "测试MyBatis")
public class IndexController {
    @GetMapping("/")
    @ApiOperation(value = "获取配置")
    public String index(){

        return "abc";
    }
}
