package com.ilzf.aspect.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "切面测试")
@RestController("/")
public class IndexController {


    @ApiOperation(value = "测试切面返回值是String")
    @GetMapping("/")
    public String index() {
        return "1111";
    }

    @ApiOperation(value = "测试切面返回值是String有输入值")
    @GetMapping("/inputString")
    public String inputString(String str) {
        return str;
    }


    @ApiOperation(value = "测试切面返回值是int")
    @GetMapping("/index2")
    public int index2() {
        return 1;
    }

    @ApiOperation(value = "报错测试")
    @GetMapping("/error")
    public int index3() {
        int a = 1 / 0;
        return 1;
    }


}
