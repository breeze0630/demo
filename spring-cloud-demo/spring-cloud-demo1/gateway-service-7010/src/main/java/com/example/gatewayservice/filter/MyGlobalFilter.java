package com.example.gatewayservice.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * @author: liubiao
 * @date: 2021/10/29 19:41
 * @Description:
 */
@Configuration
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        log.info("请求入参:{}",JSON.toJSONString(request.getQueryParams()));
        log.info("请求体:{}",JSON.toJSONString(request.getBody()));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
