package com.demo.sharding.sphere.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@SpringBootApplication
@Slf4j
public class ShardingSphereStartApplication {

    public static void main(String[] args) {
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
