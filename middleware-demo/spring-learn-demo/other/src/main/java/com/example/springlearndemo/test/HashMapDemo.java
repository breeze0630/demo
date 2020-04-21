package com.example.springlearndemo.test;

import java.util.HashMap;

/**
 * 测试红黑树
 * */
public class HashMapDemo {

    public static void main(String[] args) {

        int size = 3;
        HashMap<Integer ,Integer > map = new HashMap<>(size);
        HashMap<String ,String > stringMap = new HashMap<>(size);

        int i = size ;
        while (i > 0) {
            map.put(i,i);
            stringMap.put(String.valueOf(i),String.valueOf(i));
            i--;
        }


        System.out.println(map.toString());
        System.out.println(stringMap.toString());
    }
}
