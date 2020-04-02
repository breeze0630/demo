package com.example.springlearndemo.other.annotation.anno;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.AnnotatedElement;

@TransactionalService(name = "ccc")
public class TransactionServiceAnnotationRefectionBootstrap {
    public static void main(String[] args) {
        //Class 实现了AnnotatedElement 类
        AnnotatedElement annotatedElement = TransactionServiceAnnotationRefectionBootstrap.class;

        // 从AnnotatedElement 获取 TransactionService
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        //显示的调用属性方法  TransactionalService#name() 获取属性
        String nameAttribute = transactionalService.name();
        System.out.println("TransactionalService.name() = " + nameAttribute);


        //完全通过反射实现 ReflectionUtils 是Spring的反射工具类
        ReflectionUtils.doWithMethods(TransactionalService.class,method -> System.out.printf("@TransactionService.%s() = %s\n",method.getName(),ReflectionUtils.invokeMethod(method,transactionalService)),method -> method.getParameterCount() == 0);

        ReflectionUtils.doWithFields(TransactionalService.class,field -> System.out.printf("@TransactionService.%s() = %s\n",field.getName(),field.toString()));

    }
}
