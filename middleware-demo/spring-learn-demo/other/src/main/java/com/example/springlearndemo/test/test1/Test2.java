package com.example.springlearndemo.test.test1;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/8/11
 */
public class Test2 {
    public static void main(String[] args) {
        String s = args[0];
        System.out.println(s);

        String s2 = s
                .replaceAll("\\\\","\\\\\\\\")
                .replaceAll("'", "\\\\'");

        System.out.println(s2);
    }
}
