package com.example.generic;


import java.util.ArrayList;
import java.util.Collection;


/**
 * 测试泛型擦写
 *
 *
 * */
public class GenericApplication {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();

        list.add("String1");
        list.add("String2");

        Collection collection = list;
        collection.add(1);
        System.out.println(list);
        System.out.println(collection);


        /*
         *
         *

         编译后代码：

         Collection<String> list = new ArrayList();
         list.add("String1");
         list.add("String2");
         list.add(1);
         System.out.println(list);
         System.out.println(list);



         * */

    }

}
