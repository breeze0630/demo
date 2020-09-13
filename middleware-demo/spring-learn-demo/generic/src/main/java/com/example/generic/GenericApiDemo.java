package com.example.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Description
 * @Date: 2020/9/13 12:57
 * @Create by external_ll@163.com
 **/
public class GenericApiDemo {

    public static void main(String[] args) {

        Class intClass = int.class;

        Class objectArrayClass = Object[].class;

        Class rawClass = String.class;


//        ParameterizedType genericClass =(ParameterizedType) ArrayList.class.getGenericSuperclass();
        ParameterizedType parameterizedType =(ParameterizedType) ArrayList.class.getGenericSuperclass();

        //parameterizedType.getRawType() == class java.util.AbstractList
        System.out.println(parameterizedType.getRawType());
        //输出：  java.util.AbstractList<E>
        System.out.println(parameterizedType.toString());

        Type[] type = parameterizedType.getActualTypeArguments();
        Stream.of(type).forEach(System.out::println);

        Stream.of(type).map(TypeVariable.class::cast).forEach(System.out::println);

    }
}
