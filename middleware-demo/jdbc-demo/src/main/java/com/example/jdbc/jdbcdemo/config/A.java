package com.example.jdbc.jdbcdemo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/8 10:37
 * @Create by external_ll@163.com
 **/
@Configuration
//@AutoConfigureAfter(B.class)
@Order(AutoConfigureOrder.DEFAULT_ORDER-1)

public class A {


    @PostConstruct
    public void init(){
        System.out.println("A");
    }
}
