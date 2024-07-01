package com.example.other;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;


@SpringBootTest
//@TestPropertySource("classpath:application.yml")
class OtherApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("日期 90 天:"+LocalDate.now().plusDays(-90));
        System.out.println("日期 30 天:"+LocalDate.now().plusDays(-30));
        System.out.println("日期 7 天:"+LocalDate.now().plusDays(-7));

    }

}
