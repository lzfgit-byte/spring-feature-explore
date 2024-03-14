package com.ilzf.feign.client.serverOne.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * contextId 给feign起别名，
 */
@FeignClient(value = "serverOne", contextId = "serverOneFeign")
public interface ServerOneFeign {
    /**
     * 测试服务1
     *
     * @return
     */
    @GetMapping(path = "/indexServerOne")
    public String index();
}
