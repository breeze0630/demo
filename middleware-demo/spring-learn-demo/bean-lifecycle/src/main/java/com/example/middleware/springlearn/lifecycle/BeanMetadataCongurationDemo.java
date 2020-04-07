package com.example.middleware.springlearn.lifecycle;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

public class BeanMetadataCongurationDemo
{
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory= new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader definitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        String location = "/META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        // 直接使用 definitionReader.loadBeanDefinitions(location); 加载时，可能会出现乱码问题，需在读取资源时，标注字符集
        int beanNumbers = definitionReader.loadBeanDefinitions(encodedResource);
        System.out.printf("beanNumbers:{%s}\n",beanNumbers);

        User user = beanFactory.getBean("superUser",User.class);
        System.out.println(user);
    }
}
