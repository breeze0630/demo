package com.example.springlearndemo.environment;


import com.example.springlearndemo.iocdemo.container.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyPlaceHolderConfigurationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/properties-context.xml");

        User user = context.getBean("user", User.class);

        System.out.println(user);

        context.close();
    }
}
