package com.example.springlearndemo.test;


import java.util.function.Consumer;

public class LambdaDemo {
    public static void main(String[] args) {

        String a = "aa";
        Consumer<String> s = message -> test(message);

        s.accept(a);
        new Thread(() -> System.out.println("testThread")).run();

        new FunctionInterfaceTestImpl(new FunctionInterfaceTest() {
            @Override
            public void test() {
                System.out.println("FunctionInterfaceTestImpl.InnerClass.test");
            }
        }).test();

        new FunctionInterfaceTestImpl(() -> System.out.println("FunctionInterfaceTestImpl.Function.test")).test();
    }

    public static void test(String message){
        System.out.println(message);
    }
}
