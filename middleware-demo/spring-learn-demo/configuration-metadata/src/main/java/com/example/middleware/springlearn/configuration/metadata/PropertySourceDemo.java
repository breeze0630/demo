package com.example.middleware.springlearn.configuration.metadata;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:/META-INF/user-bean-definition.properties")
public class PropertySourceDemo {

    @Bean
    private User beanUser(@Value("${user.id}") Long id , @Value("${user.name}") String name){

        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PropertySourceDemo .class);

        HashMap<String,Object> propertyMap = new HashMap<>();
        propertyMap.put("user.name","刘彪878");
        org.springframework.core.env.PropertySource  myPropertySource = new MapPropertySource("first-property-source",propertyMap);

/*
        Map envMap =  applicationContext.getEnvironment().getSystemEnvironment();
        org.springframework.core.env.PropertySource  systemEnvironment = new MapPropertySource("systemEnvironment",envMap);
*/

        applicationContext.getEnvironment().getPropertySources().addBefore("systemEnvironment",myPropertySource);

        applicationContext.refresh();

        Map<String,User> userMap = applicationContext.getBeansOfType(User.class);

        System.out.println("----------------------------------------------");
        for (Map.Entry entry:userMap.entrySet()) {
            System.out.println("userInfo: beanName: " + entry.getKey() + " context: "+ entry.getValue());
        }
        System.out.println("----------------------------------------------");

        for(org.springframework.core.env.PropertySource  propertySource :  applicationContext.getEnvironment().getPropertySources()){
            System.out.println("propertySource:" + propertySource);
        }

        applicationContext.close();
    }
}
