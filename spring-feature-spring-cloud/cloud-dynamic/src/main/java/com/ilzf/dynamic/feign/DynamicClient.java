package com.ilzf.dynamic.feign;

import org.springframework.beans.factory.annotation.Autowired;

public class DynamicClient {
    @Autowired
    private DynamicFeignClientFactory<DynamicService> dynamicFeignClientFactory;

    /**
     * 执行get请求
     *
     * @param feignName 服务名
     * @param url       请求地址
     * @param params    请求参数
     * @return 返回结果
     */
    public Object executeGetApi(String feignName, String url, Object params) {
        DynamicService dynamicService = dynamicFeignClientFactory.getFeignClient(DynamicService.class, feignName);
        return dynamicService.executeGetApi(url, params);
    }

    /**
     * 执行post请求
     *
     * @param feignName 服务名
     * @param url       请求地址
     * @param params    请求参数
     * @return 返回结果
     */
    public Object executePostApi(String feignName, String url, Object params) {
        DynamicService dynamicService = dynamicFeignClientFactory.getFeignClient(DynamicService.class, feignName);
        return dynamicService.executePostApi(url, params);
    }

}
