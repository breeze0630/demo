package com.example.springlearndemo.beandemo.springbean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化示例
 * @author liubiao
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        //配置XML配置文件
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        User user = beanFactory.getBean("user-in-static-method",User.class);
        User userInInstanceBean = beanFactory.getBean("user-in-instance-method",User.class);
        User userInFactoryBean = beanFactory.getBean("user-in-factory-bean",User.class);

        System.out.println(user);
        System.out.println(userInInstanceBean);
        System.out.println(userInFactoryBean);

        System.out.println("user == userInInstanceBean : " + (user == userInInstanceBean));
        System.out.println("user == userInFactoryBean : " + (user == userInFactoryBean));
        System.out.println("userInInstanceBean == userInFactoryBean : " + (userInInstanceBean == userInFactoryBean));

    }
}
