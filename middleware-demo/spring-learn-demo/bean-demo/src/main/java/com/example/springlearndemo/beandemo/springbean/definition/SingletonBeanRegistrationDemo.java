package com.example.springlearndemo.beandemo.springbean.definition;


import com.example.springlearndemo.beandemo.springbean.definition.factory.DefaultUserFactory;
import com.example.springlearndemo.beandemo.springbean.definition.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liubiao
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建外部 UserFactory 对象
        UserFactory registerUserFactory = new DefaultUserFactory();

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册外部单例对象
        beanFactory.registerSingleton("userFactory",registerUserFactory);
        applicationContext.refresh();

        // 依赖查找时，如果没有查找到，会 抛出 NoSuchBeanDefinitionException
        /*
        * Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'userFactory1' available
         * */
        UserFactory userFactory  = beanFactory.getBean("userFactory",UserFactory.class);
        System.out.println(userFactory);
        System.out.println("registerUserFactory == userFactory : " + ( registerUserFactory == userFactory ));
        applicationContext.close();

    }
}
