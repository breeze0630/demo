package com.example.middleware.springlearn.configuration.metadata;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * 基于Spring 注解 SpringIOC 容器元信息配置示例
 * */
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@PropertySource("classpath:/META-INF/user-bean-definition.properties")
@Import(User.class)
public class AnnotatedSpringIocContainerMetadataConfigurationDemo {

    @Bean
    private User beanUser(@Value("${user.id}") Long id , @Value("${user.name}") String name){

        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedSpringIocContainerMetadataConfigurationDemo.class);

        applicationContext.refresh();

        Map<String,User> userMap = applicationContext.getBeansOfType(User.class);

        System.out.println("----------------------------------------------");
        for (Map.Entry entry:userMap.entrySet()) {
            System.out.println("userInfo: beanName: " + entry.getKey() + " context: "+ entry.getValue());
        }
        System.out.println("----------------------------------------------");
        applicationContext.close();
    }
}
