package com.ilzf.anno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "132";
    }

}
