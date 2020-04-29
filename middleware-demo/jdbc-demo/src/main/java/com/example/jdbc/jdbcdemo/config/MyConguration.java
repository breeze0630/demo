package com.example.jdbc.jdbcdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 项目启动时，会自动将application.properties 中的test.name 通过 set() 方法注入到 name 中
 * 配置类生效有2种方式
 * a. 配置类上添加 @Component 注册为spring bean
 * b.其他配置或者启动类上 添加 @EnableConfigurationProperties(MyConguration.class) 来注册，  可同时注册多个
 *
 * */
@ConfigurationProperties(prefix = "test")
//@Component
public class MyConguration {

    public static String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        MyConguration.name = name;
    }

}
