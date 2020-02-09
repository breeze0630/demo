package com.example.springlearndemo.beandemo.springbean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreateDemo {

    public static void main(String[] args) {
        //1 通过BeanDefinitionBuilder 创建
        // rootBeanDefinition 也可以创建，但是此方法创建是根对象（没有继承其他类的情况） 一般都用 genericBeanDefinition 即可
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置properties
        beanDefinitionBuilder.addPropertyValue("id",3);
        beanDefinitionBuilder.addPropertyValue("name","刘彪");

        //BeanDefinition 并非终态 ，可以自定义修改
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println("beanDefinition 对象："+beanDefinition);

        //2. 通过AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 设置属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id",4)
                .add("name","刘彪");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
//        User user = (User) genericBeanDefinition.get();
        System.out.println("genericBeanDefinition 对象："+genericBeanDefinition.getBeanClass().toString());

    }
}
