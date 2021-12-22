package com.example.mybatis.dynamic.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, TransactionAutoConfiguration.class})
@MapperScan(basePackages = {"com.example.mybatis.dynamic.example.domain.mapper"},sqlSessionFactoryRef="shawnTimeSqlSessionFactory")
@ImportResource("classpath:mybatis.xml")
public class MybatisDynamicExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicExampleApplication.class, args);
    }

}
