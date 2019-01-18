package com.jsako.springcloud.dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2018/12/18
 * @Author LLJ
 * @Description
 */
@Configuration
public class TemplateConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /*
    @Bean
    public IRule myRule(){
        return new RetryRule();
    }*/
}
