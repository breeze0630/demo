package com.example.springlearndemo.function;

import java.util.function.Function;

public class Example {

    private String name;

    private String address;

    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    Example(String name, String address){
        this.name = name;
        this.address = address;
    }

    Example(){}

    public static void main(String[] args) {
        InterfaceExample com =  Example::new;
        Example bean = com.create("name","address");
        System.out.println(bean.name);


        Function<Integer, Example[]> function = Example[]::new;

        Example[] array = function.apply(4);	//这里的4是数组的大小

        int i = 0;
        for(;i<array.length;i++){
            array[i] = com.create("name"+i,"address"+i);
//            System.out.println(e);	//如果输出的话，你会发现会输出4个空对象(null)
        }
        for(Example e:array){
            System.out.println(e);	//如果输出的话，你会发现会输出4个空对象(null)
        }
    }
}
