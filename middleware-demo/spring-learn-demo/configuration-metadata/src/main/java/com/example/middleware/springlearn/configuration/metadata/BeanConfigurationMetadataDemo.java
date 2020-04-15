package com.example.middleware.springlearn.configuration.metadata;

import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;

/**
 * Bean Configuration Metadata
 * Bean配置元信息示例
 * */
public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {



        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        definitionBuilder.addPropertyValue("name","xialili");

        AbstractBeanDefinition definition = definitionBuilder.getBeanDefinition();
        // 附加属性 不会影响Bean的实例化和初始化 （这不是Bean的属性信息） 不影响 populate 、Initialize 过程
        definition.setAttribute("name","夏丽丽");
        // AbstractBeanDefinition 才能调用 setSource (辅助信息)
        definition.setSource(BeanConfigurationMetadataDemo.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(ObjectUtils.nullSafeEquals("user",beanName) && User.class.equals(bean.getClass())){
                    BeanDefinition bd = beanFactory.getBeanDefinition("user");
                    if(BeanConfigurationMetadataDemo.class.equals(bd.getSource())) {
                        String name = (String) bd.getAttribute("name");
                        User user = (User) bean;
                        System.out.println("postProcessAfterInitialization() 修改前 user :" + user.toString());
                        user.setName("夏丽丽");
                        return bean;
                    }
                }
                return null;
            }
        });
        beanFactory.registerBeanDefinition("user",definition);

        System.out.println(beanFactory.getBean("user"));
    }
}
