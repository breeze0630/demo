package com.example.springlearndemo.other.web.config;

import com.example.springlearndemo.other.web.service.impl.NameServiceImpl;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Configuration
public class RegisticsBean {

    @PostConstruct
    public void init(){
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(RegisticsBean.class);

        AnnotationConfigApplicationContext applicationContext = (AnnotationConfigApplicationContext)BeanUtil.context;
        applicationContext.refresh();
        registerBeanDefinition(applicationContext,"nameServiceImpl");
//        applicationContext.close();
    }

    public void registerBeanDefinition(BeanDefinitionRegistry registry , String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(NameServiceImpl.class);


        if(StringUtils.hasText(beanName)){
            //有Bean 名称 ，注册Bean
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());

        }else {
            //无Bean 名称，通过 BeanDefinitionReaderUtils 工具类 注册，bean名称将有API 自行命名
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }


    }
}
