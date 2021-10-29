package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaiduGatewayConfig {

    //代码方式配置
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();

        builder.route("payment-route_code",k -> k.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return builder.build();
    }
}
