package com.jsako.springcloud.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2018/12/17
 * @Author LLJ
 * @Description
 */
@RequestMapping("/api/discovery")
@RestController
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public Object discovery() {
        return discoveryClient;
    }
}
