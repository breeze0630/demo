package com.example.springlearndemo.annotation;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

//通过注解注入相关组件到spring中
@Import(HelloWorldConfiguration.class) //第一种实现：通过Configuration 注入
//@Import(HelloWorldImportSelector.class) //第二种实现：通过ImportSelector 注入 selectImports
//@Import(HelloWorldBeanDefinitionRegister.class)// 第三种实现：通过ImportBeanDefinitionRegister
public @interface EnableHelloWorld {

}
