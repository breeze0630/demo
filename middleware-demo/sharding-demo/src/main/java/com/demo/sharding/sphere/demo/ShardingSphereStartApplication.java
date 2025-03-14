package com.demo.sharding.sphere.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.sql.SQLException;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@SpringBootApplication
//        (exclude = {JtaAutoConfiguration.class})
@Slf4j
@EnableAsync
@MapperScan( "com.demo.sharding.sphere.demo.mapper")
public class ShardingSphereStartApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ShardingSphereStartApplication.class, args);
        log.info("" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "============== ShardingSphereStartApplication start successfully ======================\n" +
                " ==============  http://localhost:9020/doc.html    ======================\n" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "");
    }
}
