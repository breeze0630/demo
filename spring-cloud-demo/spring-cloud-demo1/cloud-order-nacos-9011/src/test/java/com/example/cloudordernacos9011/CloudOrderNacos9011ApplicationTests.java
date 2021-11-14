package com.example.cloudordernacos9011;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class CloudOrderNacos9011ApplicationTests {

    @Test
    void contextLoads() {

        long windowTime = System.currentTimeMillis();
        System.out.println(windowTime);
        System.out.println( windowTime%500);

        System.out.println(windowTime - windowTime%500);


        long timeId = windowTime / 500;

        System.out.println(timeId);
        System.out.println((int)(timeId % 2));
    }

}
