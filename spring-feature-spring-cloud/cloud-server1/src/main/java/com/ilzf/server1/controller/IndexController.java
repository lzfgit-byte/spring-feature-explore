package com.ilzf.server1.controller;

import com.ilzf.feign.client.serverTwo.api.ServerTwoFeign;
import com.ilzf.starter.service.ILzfService;
import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api("server1")
@RestController
public class IndexController {
    @Autowired
    ILzfService iLzfService;
    @Value("${ilzf.show.name}")
    public String text;

    @Autowired
    ServerTwoFeign serverTwoFeign;

    @ApiOperation(value = "测试云配置")
    @GetMapping("/")
    public String index() {
        LogUtil.log(this.text);
        return iLzfService.getName();
    }

    @ApiOperation(value = "返回对象Obj")
    @GetMapping("/2Obj")
    public Object index2Obj() {
        LogUtil.log("ss");
        List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        return collect;
    }

    @ApiOperation(value = "测试feign")
    @GetMapping("/indexServerOne")
    public String indexServerOne(HttpServletRequest request) {
        System.out.println("");
        return serverTwoFeign.index();
    }
}