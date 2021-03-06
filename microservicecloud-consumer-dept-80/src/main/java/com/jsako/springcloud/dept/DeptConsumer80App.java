package com.jsako.springcloud.dept;

import com.jsako.springcloud.customribbon.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MyRuleConfig.class)
@EnableHystrix
public class DeptConsumer80App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80App.class,args);
       // ScheduledFuture<?> scheduledFuture = new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(() -> System.out.println("123"), 10000, 3000, TimeUnit.MILLISECONDS);
    }
}
