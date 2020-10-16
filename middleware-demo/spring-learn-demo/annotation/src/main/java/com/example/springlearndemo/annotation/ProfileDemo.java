package com.example.springlearndemo.annotation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 *
 *
 *
 * @see Environment#getActiveProfiles()
 * */
public class ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ProfileDemo.class);

        ConfigurableEnvironment environment =  applicationContext.getEnvironment();
        //设置默认的profile
        environment.setDefaultProfiles("odd");

        //设置活跃的profile
        environment.setActiveProfiles("even");
        applicationContext.refresh();

        Integer number = applicationContext.getBean("number", Integer.class);

        System.out.println(number);

        applicationContext.close();
    }

    @Bean(name = "number")
    @Profile(value = "odd")
    public Integer odd(){
        return 1;
    }

    @Bean(name = "number")
//    @Profile(value = "even")
    @Conditional(EvenCondition.class)
    public Integer even(){
        return 2;
    }
}
