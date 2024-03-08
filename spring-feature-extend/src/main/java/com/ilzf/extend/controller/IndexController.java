package com.ilzf.extend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("extend")
@RestController("/")
public class IndexController {

    @ApiOperation(value = "测试业务")
    @GetMapping("/")
    public String index() {
        return "";
    }
}
