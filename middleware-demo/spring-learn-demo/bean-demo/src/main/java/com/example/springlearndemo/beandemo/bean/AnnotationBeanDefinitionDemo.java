package com.example.springlearndemo.beandemo.bean;

import com.example.springlearndemo.beandemo.springbean.definition.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author liubiao
 */
/**
 * @Import 导入Bean
 * 一般配置类中导入信息
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        //创建BeanFactory 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //注册应用上下文
        annotationConfigApplicationContext.register(Config.class);

        //启动应用上下文
        annotationConfigApplicationContext.refresh();
        //打印Bean信息
        System.out.println("Config Bean 信息："+ annotationConfigApplicationContext.getBeansOfType(Config.class));
        System.out.println("User Bean 信息: "+ annotationConfigApplicationContext.getBeansOfType(User.class));
        //显示的关闭资源
        annotationConfigApplicationContext.close();

    }

    // 第二种方式  @Component 注入Bean
    // 一般内部服务Bean 使用较多
    @Component
//            (value = "config")
    public static class Config{

        // 第一种方式  @Bean 注入Bean
        //一般配置类型用的较多

        @Bean(name = {"user","user-liubiao"})
        public User getUser(){

            User user = new User();
            user.setId(1L);
            user.setName("liubiao");
            return user;
        }
    }


}
