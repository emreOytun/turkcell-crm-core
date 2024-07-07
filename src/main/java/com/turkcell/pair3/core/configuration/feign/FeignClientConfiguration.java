package com.turkcell.pair3.core.configuration.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}