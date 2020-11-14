package com.example.middleware.springlearn.lifecycle;


import com.example.middleware.springlearn.lifecycle.domain.UserHolder;
import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInitializationLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();
    }

    /**
     * DefaultListableBeanFactory 此方法没有回调 environment，
     * EnvironmentAware 接口是和应用上下文相关的回调
     * */
    private static void executeBeanFactory(){
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();

        /**因为这里添加的顺序是 CommonAnnotationBeanPostProcessor  -> MyInstantiationAwareBeanPostProcessor
         *所以initPostConstruct 先于 postProcessBeforeInitialization执行
         **/
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor()); // 添加此Processor 是为了 使 PostConstruct 生效
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] location = {"classpath:/META-INF/dependency-lookup-context.xml","classpath:/META-INF/bean-constructor-dependency-injection.xml"};
        beanDefinitionReader.loadBeanDefinitions(location);

        beanFactory.preInstantiateSingletons();
        User user = beanFactory.getBean("user",User.class);

        System.out.println(user);

        SuperUser superUser = beanFactory.getBean("superUser",SuperUser.class);

        System.out.println(superUser);

        UserHolder userHolder = beanFactory.getBean("userHolder",UserHolder.class);

        System.out.println(userHolder);
    }
}

