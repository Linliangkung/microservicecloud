package com.jsako.springcloud.customribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2018/12/29
 * @Author LLJ
 * @Description
 */
@Configuration
public class MyRuleConfig {

    @Bean
    public IRule myRule(){
        return new CustomRule();
    }
}
