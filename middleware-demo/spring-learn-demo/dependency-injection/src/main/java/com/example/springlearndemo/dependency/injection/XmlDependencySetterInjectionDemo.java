package com.example.springlearndemo.dependency.injection;

import com.example.springlearndemo.dependency.injection.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlDependencySetterInjectionDemo {


    public static void main(String[] args) {


        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.printf( "userHolder class: %s\n" , userHolder);

        User user = beanFactory.getBean(User.class);
        System.out.printf( "user class: %s\n" , user);
    }
}
