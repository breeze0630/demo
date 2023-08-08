package com.example.springlearndemo.dependency.injection;

import com.example.springlearndemo.dependency.injection.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationDependencySetterInjectionDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // throw BeanInstantiationException
        // 注册 Bean 所对应的类型是接口 或者 抽象类时，均会抛出 BeanInstantiationException
        applicationContext.register(AnnotationDependencySetterInjectionDemo.class);


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

//        String xmlResourcePath = "classpath:/META-INF/dependency-setter-injection.xml";
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";


        xmlBeanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        //启动 Spring 应用上下文
        applicationContext.refresh();


        System.out.printf("userHolder class:%s\n" , applicationContext.getBean(UserHolder.class));
        System.out.printf("User class:%s\n" , applicationContext.getBean(User.class));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return  new UserHolder(user);
    }
}
