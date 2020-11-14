package com.example.middleware.springlearn.configuration.metadata;

import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;


/**
 * @see org.springframework.beans.factory.support.PropertiesBeanDefinitionReader
 * PropertiesBeanDefitionReader 示例
 * */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {

        //创建IOC 底层容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(applicationContext);
        Resource superUserResource = new ClassPathResource("META-INF/superUser.properties");
        EncodedResource superResource = new EncodedResource(superUserResource,"UTF-8");

        Resource resource = new ClassPathResource("META-INF/user.properties");
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");


        int beanDefinitionCount = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        int beanDefinitionCount2 = beanDefinitionReader.loadBeanDefinitions(superResource);

        applicationContext.refresh();

        System.out.println("beanDefinitionCount : "+ beanDefinitionCount);
        System.out.println("beanDefinitionCount2 : "+ beanDefinitionCount2);

        User user = applicationContext.getBean("user",User.class);

        SuperUser superUser = applicationContext.getBean("superUser",SuperUser.class);

        System.out.println("user : "+ user.toString());

        System.out.println("superUser : "+ superUser.toString());
    }
}
