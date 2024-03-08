package com.ilzf.extend.controller;

import com.ilzf.extend.entity.ExtendEntity;
import com.ilzf.extend.service.ExtendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("extend")
@RestController("/")
public class IndexController {

    @Autowired
    ExtendService extendService;

    @ApiOperation(value = "测试业务")
    @GetMapping("/")
    public String index() {
        ExtendEntity extend = new ExtendEntity();
        extend.setName("111");
        extend.setPassword("4444");
        extendService.getOne(extend);
        return "";
    }
}
