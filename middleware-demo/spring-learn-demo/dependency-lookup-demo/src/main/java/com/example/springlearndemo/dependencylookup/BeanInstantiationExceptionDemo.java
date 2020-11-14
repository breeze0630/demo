package com.example.springlearndemo.dependencylookup;

import com.example.springlearndemo.dependencylookup.domain.UserInterface;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInstantiationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserInterface.class);

        // throw BeanInstantiationException
        // 注册 Bean 所对应的类型是接口 或者 抽象类时，均会抛出 BeanInstantiationException
        applicationContext.registerBeanDefinition("errorBean",builder.getBeanDefinition());
        applicationContext.register(BeanInstantiationExceptionDemo.class);
        applicationContext.refresh();
        applicationContext.close();
    }
}
