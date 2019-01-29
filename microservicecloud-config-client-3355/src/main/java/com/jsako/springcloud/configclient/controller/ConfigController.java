package com.jsako.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/1/28
 * @Author LLJ
 * @Description
 */
@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Value("${server.port}")
    private int port;

    @Value("${eureka.client.service-url.defaultZone}")
    private String serviceUrl;


    @RequestMapping("/getInfo")
    public String getInfo() {
        return serviceUrl+",port:"+port;
    }
}
