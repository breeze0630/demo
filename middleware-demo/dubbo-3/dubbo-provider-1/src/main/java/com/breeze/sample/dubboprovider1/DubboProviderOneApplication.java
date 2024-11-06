package com.breeze.sample.dubboprovider1;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.breeze.sample.dubboprovider1.mapper")
public class DubboProviderOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderOneApplication.class, args);
        System.out.println("DubboProvider1Application 启动成功  \n" + "________________________   \n" +
                "\\_____  \\__    ___/  _  \\  \n" +
                " /   |   \\|    | /  /_\\  \\ \n" +
                "/    |    \\    |/    |    \\\n" +
                "\\_______  /____|\\____|__  /\n" +
                "        \\/              \\/ ");
    }
}
