package com.example.springlearndemo.jdk;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/21 19:32
 * @Create by external_ll@163.com
 **/
public class StringDemo {

    public static void main(String[] args) {
        String str = "";
        int max = 10000000;
        while (max>0){
            str = str +"1";
            max --;
        }
        System.out.println(str);
    }
}
