package com.example.jdbc.jdbcdemo;

import com.example.jdbc.jdbcdemo.config.MyConguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 配置开关
 *
 * @author liubiao
 */
@SpringBootApplication
@EnableConfigurationProperties(MyConguration.class)
public class JdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

}
