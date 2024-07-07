package com.turkcell.pair3.core.configuration.feign;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FeignClientInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            String token = attributes.getRequest().getHeader("Authorization");
            if (token != null && token.startsWith("Bearer")) {
                token = token.substring(7);
                template.header("Authorization", "Bearer " + token);
            }
        }
    }
}
