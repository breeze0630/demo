package com.example.springlearndemo.beandemo.springbean.definition;

import com.example.springlearndemo.beandemo.springbean.definition.factory.DefaultUserFactory;
import com.example.springlearndemo.beandemo.springbean.definition.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liubiao
 *
 * Bean的初始化 示例：
 * 初始化 定义方式分3种：
 * 1、XML配置
 * 2、JAVA 注解 @PostConstruct
 * 3、JAVA API : org.springframework.beans.factory.support.AbstractBeanDefinition#setDestroyMethodName(java.lang.String)
 *
 * 日志输出：
 * @PostConstruct 调用 ：初始化中......
 * afterPropertiesSet 调用 ： 初始化中 ......
 * initMethod 调用 ： 初始化中 ......
 *
 *
 * 销毁 定义方式分3种：
 * 1、XML配置
 * 2、JAVA 注解 @PreDestroy
 * 3、JAVA API : org.springframework.beans.factory.support.AbstractBeanDefinition#setDestroyMethodName(java.lang.String)
 * 执行顺序 @PreDestroy > JAVA API > XML 配置
 * 示例中顺序 @PreDestroy >> destroy >> doDestroy
 *
 * close 触发对象销毁
 * 日志输出：
 * @PreDestroy 调用 ：对象销毁......
 * @destroy 回调 ：对象销毁......
 * 自定义方法 doDestroy 回调 ：对象销毁......
 *
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        System.out.println("Spring 上下文已启动....");
//        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

//        System.out.println(userFactory);
        applicationContext.close();
//        System.gc();
    }

    /**
     * 延迟初始化 Bean的初始化在注册Bean时不初始化，只是在获取Bean的时候才会初始化
     * 非延迟初始化 在注册Bean时就会初始化
     * */
    @Bean(initMethod = "initMethod",destroyMethod = "doDestroy")
//    @Lazy
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }



}
