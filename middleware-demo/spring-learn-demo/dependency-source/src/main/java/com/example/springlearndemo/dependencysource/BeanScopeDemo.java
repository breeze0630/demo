package com.example.springlearndemo.dependencysource;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class BeanScopeDemo {
    //默认的 scope 是 singleton
    @Bean
    public static User singletonUser(){
        return currentUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser(){
        return  currentUser();
    }


    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;
    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1 ;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    public static User currentUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanScopeDemo.class);

        applicationContext.refresh();

        scopedBeanByLookup(applicationContext);

        scopedBeanByInjection(applicationContext);
        applicationContext.close();
    }

    public static void scopedBeanByLookup(AnnotationConfigApplicationContext applicationContext){
        for (int i = 0 ; i < 3 ; i++){
            User singletonUser = applicationContext.getBean("singletonUser",User.class);
            System.out.println("singletonUser  == " + singletonUser);

            User prototypeUser = applicationContext.getBean("prototypeUser",User.class);
            System.out.println("prototypeUser  == " + prototypeUser);

        }
    }

    public static void scopedBeanByInjection(AnnotationConfigApplicationContext applicationContext){
        System.out.println("============scopedBeanByInjection===============");
        BeanScopeDemo demo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("singletonUser == " + demo.singletonUser);
        System.out.println("singletonUser1 == " + demo.singletonUser1);
        System.out.println("prototypeUser == " + demo.prototypeUser);
        System.out.println("prototypeUser1 == " + demo.prototypeUser1);
        System.out.println("prototypeUser2 == " + demo.prototypeUser2);

    }

}
