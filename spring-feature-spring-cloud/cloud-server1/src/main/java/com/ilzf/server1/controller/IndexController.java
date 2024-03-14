package com.ilzf.server1.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ilzf.starter.service.ILzfService;
import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("server1")
@RestController
public class IndexController {
    @Autowired
    ILzfService iLzfService;
    @Value("${ilzf.show.name}")
    public String text;

    @ApiOperation(value = "测试云配置")
    @GetMapping("/")
    public String index() {
        LogUtil.log(this.text);
        return iLzfService.getName();
    }

    @ApiOperation(value = "测试云配置")
    @GetMapping("/indexServerOne")
    public String indexServerOne() {
        LogUtil.log(this.text);
        return iLzfService.getName();
    }
}