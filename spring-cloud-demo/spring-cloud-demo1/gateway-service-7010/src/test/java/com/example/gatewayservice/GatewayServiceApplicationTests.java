package com.example.gatewayservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class GatewayServiceApplicationTests {

    @Test
    void contextLoads() {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
