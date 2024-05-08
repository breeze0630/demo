package com.example;

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
public class Consumer2StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Consumer2StartApplication.class, args);
        log.info("" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "============== Consumer2StartApplication start successfully ======================\n" +
                " ==============  http://localhost:8082/doc.html    ======================\n" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "");
    }
}
