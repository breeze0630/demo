package com.example.springlearndemo.dependencylookup;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;

/**
 *
 * 层次性依赖查找
 *
 * ObjectProvider 是延迟依赖查找接口 但是需要依赖Spring 5
 * @author liubiao
 */
@Configuration
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);

        

        applicationContext.close();
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "hello,world";
    }

    @Bean
    public String message(){
        return "message";
    }

    public static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        Iterator<String> stringIterator = objectProvider.iterator();
        while (stringIterator.hasNext()){
            String string  = stringIterator.next();
            System.out.println(string);
        }

        Iterable<String> stringIterable = objectProvider;
        for (String string : stringIterable){
            System.out.println(string);
        }
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("当前 User 对象 ：" + user);
    }


    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
