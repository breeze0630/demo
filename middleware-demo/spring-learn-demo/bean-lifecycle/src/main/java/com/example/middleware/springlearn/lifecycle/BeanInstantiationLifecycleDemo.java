package com.example.middleware.springlearn.lifecycle;


import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.util.ObjectUtils;

public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] location = {"classpath:/META-INF/dependency-lookup-context.xml","classpath:/META-INF/bean-constructor-dependency-injection.xml"};
        beanDefinitionReader.loadBeanDefinitions(location);

        User user = beanFactory.getBean("user",User.class);

        System.out.println(user);

        SuperUser superUser = beanFactory.getBean("superUser",SuperUser.class);

        System.out.println(superUser);


    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

            if(ObjectUtils.nullSafeEquals( "superUser",beanName) && SuperUser.class.equals(beanClass)){
                return  new SuperUser();
            }
            return null; //如果返回Null，保持之前的处理过程不变,采用默认的实例化方式
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if(ObjectUtils.nullSafeEquals("user",beanName) ){
                User user = (User) bean;
                user.setId(999L);
//                user.setName("测试");
                return false;
            }
            return true;
        }
    }

}
