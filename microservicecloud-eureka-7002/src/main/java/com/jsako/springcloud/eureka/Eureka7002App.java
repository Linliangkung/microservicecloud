package com.jsako.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Date 2018/12/17
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7002App {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002App.class, args);
    }
}
