package com.ilzf.feign.client.serverOne.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "serverOne", contextId = "serverOneFeign")
public class ServerOneFeign {
}
