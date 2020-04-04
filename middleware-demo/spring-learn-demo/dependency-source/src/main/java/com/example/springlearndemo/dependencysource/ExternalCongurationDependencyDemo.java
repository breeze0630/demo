package com.example.springlearndemo.dependencysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties",encoding = "utf-8")
public class ExternalCongurationDependencyDemo {

    @Value("${user.id}")
    private int id;

    @Value("${usr.name}")
    private String name;

    @Value("${user.resource:classpath:/META-INF/default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ExternalCongurationDependencyDemo.class);

        applicationContext.refresh();

        ExternalCongurationDependencyDemo dependencyDemo = applicationContext.getBean(ExternalCongurationDependencyDemo.class);

        System.out.println("demo.id = " + dependencyDemo.id);
        System.out.println("demo.name = " + dependencyDemo.name);
        System.out.println("demo.resource = " + dependencyDemo.resource);

        applicationContext.close();
    }
}
