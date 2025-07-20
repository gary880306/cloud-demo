package com.gary.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String uri = request.getURI().toString();
        long start = System.currentTimeMillis();
        log.info("請求[{}]開始，時間：{}", uri, start);
        return chain.filter(exchange).
                doFinally(signal -> {
                    long end = System.currentTimeMillis();
                    log.info("請求[{}]結束，時間：{}，耗時:{}", uri, end, end - start);
                });
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
