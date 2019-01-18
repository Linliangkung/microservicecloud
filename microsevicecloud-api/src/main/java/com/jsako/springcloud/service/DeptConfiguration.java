package com.jsako.springcloud.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.hystrix.FallbackFactory;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date 2019/1/16
 * @Author LLJ
 * @Description
 */
@Configuration
public class DeptConfiguration {

    @Bean
    public FallbackFactory fallBackFactory() {
        return new DeptFallBackFactory();
    }

    @Bean
    public SetterFactory hystrixSetter() {
        return (target, method) ->
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(target.name()))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(Feign.configKey(target.type(), method)))
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3000).withCircuitBreakerSleepWindowInMilliseconds(30000));
    }
}
