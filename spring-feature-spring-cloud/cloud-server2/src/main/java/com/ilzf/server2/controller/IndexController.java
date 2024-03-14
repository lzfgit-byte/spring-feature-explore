package com.ilzf.server2.controller;

import com.ilzf.starter.service.ILzfService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("服务2")
public class IndexController {
    @Autowired
    ILzfService iLzfService;

    public String index() {
        return iLzfService.getName();
    }
}
