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
public class Consumer1StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Consumer1StartApplication.class, args);
        log.info("" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "============== CardPrintApplication start successfully ======================\n" +
                " ==============  http://localhost:8082/doc.html    ======================\n" +
                "===============================================================================\n" +
                "===============================================================================\n" +
                "");
    }
}
