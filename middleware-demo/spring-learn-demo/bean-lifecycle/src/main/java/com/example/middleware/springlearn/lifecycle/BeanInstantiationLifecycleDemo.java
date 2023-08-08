package com.example.middleware.springlearn.lifecycle;


import com.example.middleware.springlearn.lifecycle.domain.UserHolder;
import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();
        executeApplicationContext();
    }

    /**
     * DefaultListableBeanFactory 此方法没有回调 environment，
     * EnvironmentAware 接口是和应用上下文相关的回调
     * */
    private static void executeBeanFactory(){
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] location = {"classpath:/META-INF/dependency-lookup-context.xml","classpath:/META-INF/bean-constructor-dependency-injection.xml"};
        beanDefinitionReader.loadBeanDefinitions(location);

        User user = beanFactory.getBean("user",User.class);

        System.out.println(user);

        SuperUser superUser = beanFactory.getBean("superUser",SuperUser.class);

        System.out.println(superUser);

        UserHolder userHolder = beanFactory.getBean("userHolder",UserHolder.class);

        System.out.println(userHolder);
    }
    private static void executeApplicationContext(){
        System.out.println("----executeApplicationContext----");
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext();

        //用 Xml注册Bean MyInstantiationAwareBeanPostProcessor

        String[] location = {"classpath:/META-INF/dependency-lookup-context.xml","classpath:/META-INF/bean-constructor-dependency-injection.xml"};
        applicationContext.setConfigLocations(location);

        applicationContext.refresh();
        User user = applicationContext.getBean("user",User.class);

        System.out.println(user);

        SuperUser superUser = applicationContext.getBean("superUser",SuperUser.class);

        System.out.println(superUser);

        UserHolder userHolder = applicationContext.getBean("userHolder",UserHolder.class);

        System.out.println(userHolder);
        applicationContext.close();
    }

}

