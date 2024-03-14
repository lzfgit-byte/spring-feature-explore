package com.ilzf.server2.controller;

import com.ilzf.starter.service.ILzfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("服务2")
public class IndexController {
    @Autowired
    ILzfService iLzfService;

    @GetMapping("/")
    @ApiOperation(value = "测试服务2")
    public String index() {
        return iLzfService.getName();
    }
}
