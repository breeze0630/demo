package com.example.springlearndemo.jdk;

import java.util.ArrayList;

/**
 * create by liubiao
 * date: 2020/5/6 08:44
 * className: Test
 **/
public class Test {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");

        arrayList.add("2");

        boolean a = false;
        if(a & proMethod(2)){
            System.out.println("fafadfa");
        }

        System.out.println("位移:"+((2<<3)-1));
    }

    public static boolean proMethod(int a){
        return a == 3;
    }
}
