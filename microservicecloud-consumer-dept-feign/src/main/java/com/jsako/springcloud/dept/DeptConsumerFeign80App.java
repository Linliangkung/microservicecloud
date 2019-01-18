package com.jsako.springcloud.dept;

import com.jsako.springcloud.customribbon.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyRuleConfig.class)
@EnableFeignClients(value="com.jsako.springcloud")
@EnableHystrix
public class DeptConsumerFeign80App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumerFeign80App.class,args);
    }
}
