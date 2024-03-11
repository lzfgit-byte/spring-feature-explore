package com.ilzf.testjunit.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("单元测试")
@RestController("/")
public class IndexController {


    @ApiOperation("单元测试")
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
