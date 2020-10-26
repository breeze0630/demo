package com.example.springlearndemo.reflection;

import org.springframework.util.ClassUtils;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception{
        Class userPojo = Class.forName("com.example.springlearndemo.reflection.ReflectionUserPOJO");

        Object o = userPojo.newInstance();
        Class parent = Class.forName("com.example.springlearndemo.reflection.UserParent");
        //isAssignableFrom
        System.out.println(ClassUtils.resolveClassName("com.example.springlearndemo.reflection.ReflectionUserPOJO", (ClassLoader)null).isAssignableFrom(parent));
    }
}
