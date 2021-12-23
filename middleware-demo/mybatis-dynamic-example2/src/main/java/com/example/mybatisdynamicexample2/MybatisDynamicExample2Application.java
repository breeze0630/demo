package com.example.mybatisdynamicexample2;

import com.baomidou.dynamic.datasource.plugin.MasterSlaveAutoRoutingPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mybatisdynamicexample2.domain.mapper"})
public class MybatisDynamicExample2Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicExample2Application.class, args);
    }

    @Bean
    public MasterSlaveAutoRoutingPlugin masterSlaveAutoRoutingPlugin(){
        return new MasterSlaveAutoRoutingPlugin();
    }
}
