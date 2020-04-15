package com.example.springlearndemo.test;


import java.util.function.Consumer;

public class LambdaDemo {
    public static void main(String[] args) {

        String a = "aa";
        Consumer<String> s = message -> test(message);

        s.accept(a);

    }

    public static void test(String message){
        System.out.println(message);
    }
}
