package com.example.springlearndemo.iocdemo.container;

import com.example.springlearndemo.iocdemo.container.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 *
 * {@link ApplicationContext} applicationContext IoC容器
 *
 * */
@Configuration
public class ApplicationContextAsIocContainer {

    public static void main(String[] args) {
        //创建 BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextAsIocContainer.class);
        //启动应用上下文
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User getUser(){
        User user = new User();
        user.setId(2L);
        user.setName("刘彪");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){

        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象："+ users);
        }
    }
}

