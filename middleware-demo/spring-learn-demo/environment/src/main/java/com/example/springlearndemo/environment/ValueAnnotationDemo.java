package com.example.springlearndemo.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * {@link Value}
 *
 * {@link PropertySource} 只有标注在Component 的接口上才有用,即意味着只有被spring管理到的Bean
 * 才能使用{@link PropertySource}
 * */
@PropertySource(value = "classpath:/application.properties")
@Configuration
public class ValueAnnotationDemo {


    @Value(value = "${user.id}")
    private String userId;


    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(ValueAnnotationDemo.class);
//
//        context.refresh();

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ValueAnnotationDemo.class);

        ValueAnnotationDemo demo = context1.getBean(ValueAnnotationDemo.class);
        System.out.println(demo.userId);

        context1.close();

    }
}
