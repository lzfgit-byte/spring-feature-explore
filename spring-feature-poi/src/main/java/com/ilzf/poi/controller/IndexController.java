package com.ilzf.poi.controller;

import com.ilzf.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试POI")
@RestController("/")
public class IndexController {

    @ApiOperation("pdf转图片")
    @GetMapping("/")
    public String index() {
        LogUtil.log("pdf转图片");
        return "pdf转图片";
    }
}
