package com.jsako.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Date 2019/1/29
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaConfig7001App {
    public static void main(String[] args){
        SpringApplication.run(EurekaConfig7001App.class,args);
    }
}
