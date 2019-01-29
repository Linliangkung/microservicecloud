package com.jsako.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Date 2019/1/28
 * @Author LLJ
 * @Description
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul9527App {

    public static void main(String[] args){
        SpringApplication.run(Zuul9527App.class,args);

    }
}
