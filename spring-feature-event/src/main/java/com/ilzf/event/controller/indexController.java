package com.ilzf.event.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController("/")
public class indexController {

    //    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "获取配置")
    @GetMapping("/")
    public String index() {
        return "";
    }
}
