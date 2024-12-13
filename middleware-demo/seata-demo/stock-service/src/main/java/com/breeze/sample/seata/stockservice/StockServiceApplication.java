package com.breeze.sample.seata.stockservice;

import io.seata.integration.http.TransactionPropagationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableTransactionManagement
public class StockServiceApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TransactionPropagationInterceptor());
        super.addInterceptors(registry);
    }
}
