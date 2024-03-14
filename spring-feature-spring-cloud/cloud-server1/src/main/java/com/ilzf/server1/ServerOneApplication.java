package com.ilzf.server1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("server1")
@RestController
public class ServerOneApplication {
    
    @ApiOperation(value = "测试云配置")
    @GetMapping("/")
    public String index() {
        return "server1";
    }
}
