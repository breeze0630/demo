package com.breeze.sample.dubboconsumer1;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboConsumer1Application {

    public static void main(String[] args)  {
        SpringApplication.run(DubboConsumer1Application.class, args);
        System.out.println("DubboConsumer1Application 启动成功  \n" + "________________________   \n" +
                "\\_____  \\__    ___/  _  \\  \n" +
                " /   |   \\|    | /  /_\\  \\ \n" +
                "/    |    \\    |/    |    \\\n" +
                "\\_______  /____|\\____|__  /\n" +
                "        \\/              \\/ ");
    }
}
