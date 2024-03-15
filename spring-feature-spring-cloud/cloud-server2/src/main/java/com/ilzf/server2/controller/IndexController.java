package com.ilzf.server2.controller;

import com.ilzf.dynamic.feign.DynamicClient;
import com.ilzf.feign.client.serverOne.api.ServerOneFeign;
import com.ilzf.starter.service.ILzfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api("服务2")
public class IndexController {
    @Autowired
    ILzfService iLzfService;
    @Autowired
    ServerOneFeign serverOneFeign;
    @Autowired
    DynamicClient dynamicClient;

    @GetMapping("/")
    @ApiOperation(value = "测试服务2")
    public String index() {
        return iLzfService.getName();
    }


    @GetMapping("/testFeign")
    @ApiOperation(value = "测试服务1 feign")
    public String index2() {
        return serverOneFeign.index();
    }

    @GetMapping("/testDynamicFeign")
    @ApiOperation(value = "测试动态构建feign")
    public String testDynamicFeign() {
        Object obj = dynamicClient.executeGetApi("serverOne", "/", new HashMap<>());
        return (String) obj;
    }
}
