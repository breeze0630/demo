package com.example.springlearndemo.environment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class InjectingEnvironmentDemo implements EnvironmentAware , ApplicationContextAware  {

    private Environment environment;

    @Autowired
    private Environment environment2;

    private ApplicationContext applicationContext;


    @Autowired
    private ApplicationContext applicationContext2;
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingEnvironmentDemo.class);

        context.refresh();

        InjectingEnvironmentDemo demo = context.getBean(InjectingEnvironmentDemo.class);

        System.out.println(demo.environment);

        //true
        System.out.println(demo.environment == demo.environment2);
        //true
        System.out.println(demo.environment == context.getEnvironment());
        //true
        System.out.println(demo.applicationContext == demo.applicationContext2);
        //true
        System.out.println(demo.applicationContext == context);

        context.close();
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
