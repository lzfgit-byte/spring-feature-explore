package com.ilzf.server2.controller;

import com.ilzf.feign.client.serverOne.api.ServerOneFeign;
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
    @Autowired
    ServerOneFeign serverOneFeign;

    @GetMapping("/")
    @ApiOperation(value = "测试服务2")
    public String index() {
        return iLzfService.getName();
    }

    @GetMapping("/indexServer2")
    @ApiOperation(value = "测试服务2")
    public String indexServer2() {
        return iLzfService.getName();
    }

    @GetMapping("/testFeign")
    @ApiOperation(value = "测试服务1 feign")
    public String index2() {
        return serverOneFeign.index();
    }
}
