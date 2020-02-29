package com.example.springlearndemo.dependencylookup;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(UnUniqueBeanDefinitionExceptionDemo.class);

        applicationContext.refresh();



        try {
            applicationContext.getBean(User.class);
        }catch (NoUniqueBeanDefinitionException e){
            System.err.printf(" Spring 应用上下文存在 %d个 %s 类型的 Bean，具体原因：%s\n",e.getNumberOfBeansFound(),User.class.getName(),e.getMessage());
        }
        applicationContext.close();
    }

    @Bean
    public User bean1(){
        User user = new User();
        user.setId(1L);
        user.setName("bean1");
        return user;
    }

    @Bean
    public User bean2(){
        User user = new User();
        user.setId(2L);
        user.setName("bean2");
        return user;
    }



}
