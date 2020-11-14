package com.example.springlearndemo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableHelloWorld
public class EnableModuleDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(EnableModuleDemo.class);

        applicationContext.refresh();

        String helloWorld = applicationContext.getBean("helloWorld", String.class);

        System.out.println(helloWorld);

        applicationContext.close();
    }
}
