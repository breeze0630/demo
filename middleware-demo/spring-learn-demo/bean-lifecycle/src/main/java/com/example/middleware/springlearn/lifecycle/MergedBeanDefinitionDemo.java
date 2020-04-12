package com.example.middleware.springlearn.lifecycle;


import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionCounts = beanDefinitionReader.loadBeanDefinitions(location);

        System.out.println("BeanDefinition数量："+ beanDefinitionCounts);


        User user = beanFactory.getBean("user",User.class);

        System.out.println(user);

        SuperUser superUser = beanFactory.getBean("superUser",SuperUser.class);

        System.out.println(superUser);
    }
}
