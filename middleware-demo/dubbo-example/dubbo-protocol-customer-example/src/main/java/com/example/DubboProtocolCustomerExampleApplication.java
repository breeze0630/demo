package com.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example")
public class DubboProtocolCustomerExampleApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DubboProtocolCustomerExampleApplication.class,args);
    }
}
