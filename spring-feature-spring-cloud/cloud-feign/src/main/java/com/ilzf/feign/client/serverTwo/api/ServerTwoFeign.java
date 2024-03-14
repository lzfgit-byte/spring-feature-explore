package com.ilzf.feign.client.serverTwo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * contextId 给feign起别名，
 */
@FeignClient(value = "serverTwo", contextId = "serverTwoFeign")
public interface ServerTwoFeign {
    /**
     * 测试服务1
     *
     * @return
     */
    @GetMapping(path = "/")
    public String index();
}
