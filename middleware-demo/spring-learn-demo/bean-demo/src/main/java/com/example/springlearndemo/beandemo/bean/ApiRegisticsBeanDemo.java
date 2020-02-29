package com.example.springlearndemo.beandemo.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author liubiao
 * 通过API 注册Bean
 */
public class ApiRegisticsBeanDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApiRegisticsBeanConfig.class);
        applicationContext.refresh();

        registerBeanDefinition(applicationContext,"likelxl-user");
        registerBeanDefinition(applicationContext);
        registerBeanDefinition(applicationContext);

        System.out.println("User Bean 信息: "+ applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }
    public static void registerBeanDefinition(BeanDefinitionRegistry registry , String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",2L).addPropertyValue("name","liubiao");


        if(StringUtils.hasText(beanName)){
            //有Bean 名称 ，注册Bean
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());

        }else {
            //无Bean 名称，通过 BeanDefinitionReaderUtils 工具类 注册，bean名称将有API 自行命名
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }


    }


    public static void registerBeanDefinition(BeanDefinitionRegistry registry ){
        registerBeanDefinition(registry,null);
    }


    // 第二种方式  @Component 注入Bean
    // 一般内部服务Bean 使用较多
    @Component
    public static class ApiRegisticsBeanConfig{

        // 第一种方式  @Bean 注入Bean
        //一般配置类型用的较多

        @Bean(name = {"user","user-liubiao"})
        public User getUser(){

            User user = new User();
            user.setId(2L);
            user.setName("liubiao");
            return user;
        }
    }

}
