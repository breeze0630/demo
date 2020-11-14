package com.example.jdbc.jdbcdemo.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

/**
 * AutoConfigureOrder 和 AutoConfigureAfter 以及 AutoConfigureBefore 都需要和spring.factories 搭配才能生效
 * 需要配置
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.example.jdbc.jdbcdemo.config.A,\
 *   com.example.jdbc.jdbcdemo.config.B
 * @Description TODO
 * @Date: 2020/5/8 10:38
 * @Create by external_ll@163.com
 **/
@Configuration
@Order(AutoConfigureOrder.DEFAULT_ORDER-2)

public class B {

    @PostConstruct
    public void init(){
        System.out.println("B");
    }
}
