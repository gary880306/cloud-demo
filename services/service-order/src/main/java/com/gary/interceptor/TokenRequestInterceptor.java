package com.gary.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenRequestInterceptor implements RequestInterceptor {

    // 請求攔截器
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("TokenRequestInterceptor ......");
        requestTemplate.header("token", UUID.randomUUID().toString());
    }
}
