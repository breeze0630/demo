package com.example.springlearndemo.dependencylookup;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TypeSafetyDependencyDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();


        displayBeanFactoryGetBean(applicationContext);

        displayObjectFactoryGetObject(applicationContext);

        displayObjectProviderIfAvailable(applicationContext);

        displayListableBeanFactory(applicationContext);

        displayObjectProviderStreamOps( applicationContext );


        applicationContext.close();
    }

    public static void   displayObjectProviderStreamOps(BeanFactory beanFactory){
        ObjectProvider<User> userObjectFactory = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps",() -> userObjectFactory.forEach(System.out::println));
    }
    public static void   displayListableBeanFactory(ListableBeanFactory beanFactory){
        printBeansException("displayListableBeanFactory",() -> beanFactory.getBeansOfType(User.class));
    }

    public static void   displayObjectProviderIfAvailable(BeanFactory beanFactory){
        ObjectProvider<User> userObjectFactory = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectProviderIfAvailable",() -> userObjectFactory.getIfAvailable());
    }
    public static void   displayObjectFactoryGetObject(BeanFactory beanFactory){
        ObjectFactory<User> userObjectFactory = beanFactory.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject",() -> userObjectFactory.getObject());
    }

    public static void  displayBeanFactoryGetBean(BeanFactory beanFactory){

//        try {
//            beanFactory.getBean(User.class);
//        }   catch (BeansException exception){
//            exception.printStackTrace();
//        }

        printBeansException("displayBeanFactoryGetBean",() -> beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source , Runnable runnable){

        System.err.println("====================================");
        System.err.println("source from : " + source);
        try {
            runnable.run();
        }   catch (BeansException e){
            e.printStackTrace();
        }

    }
}
