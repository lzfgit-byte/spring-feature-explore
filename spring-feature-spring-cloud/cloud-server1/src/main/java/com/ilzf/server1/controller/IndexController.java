package com.ilzf.server1.controller;

import com.ilzf.starter.service.ILzfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("server1")
@RestController
public class IndexController {
    @Autowired
    ILzfService iLzfService;

    @ApiOperation(value = "测试云配置")
    @GetMapping("/")
    public String index() {
        return iLzfService.getName();
    }
}