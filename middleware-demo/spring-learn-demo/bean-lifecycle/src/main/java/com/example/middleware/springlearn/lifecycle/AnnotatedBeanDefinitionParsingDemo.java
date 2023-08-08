package com.example.middleware.springlearn.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {

//        System.out.println(Integer.valueOf("0000000000001011",2));
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();

        beanDefinitionReader.registerBean(AnnotatedBeanDefinitionParsingDemo.class);
        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();

        System.out.println("已加载BeanDefinition数量:"+(beanDefinitionCountAfter-beanDefinitionCountBefore));

        AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean(AnnotatedBeanDefinitionParsingDemo.class);

        System.out.println(demo);
    }


}
