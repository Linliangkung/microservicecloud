package com.jsako.springcloud.dept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Date 2018/12/13
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConfigProvider8001App {
    public static void main(String[] args){
        SpringApplication.run(DeptConfigProvider8001App.class,args);
    }
}
