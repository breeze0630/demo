package com.example.middleware.springlearn.configuration.metadata;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * 测试Properties 的类型转换 以及赋值等
 * */
public class PropertiesDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();

//        properties.setProperty(properties,"null");
        properties.setProperty("id","1");
        properties.setProperty("name","li");

        Map<Object,Object> map = properties;

        System.out.println("properties:"+properties.toString());
        System.out.println("map:"+map);


        Hashtable<Object,Object> hashtable = new Hashtable<>();

        hashtable.put(hashtable,"1");

        hashtable.put(hashtable,"2");

        System.out.println(hashtable);
    }
}

class ParentMethod{
    public void printMsg(){
        System.out.println("printMsg......");
    }
}

class ChildMethod extends ParentMethod{
    public void test(){
        System.out.println("test....");
        printMsg();
    }

    @Override
    public void printMsg() {
        System.out.println("ChildMethod.printMsg()");
        super.printMsg();
    }

    public static void main(String[] args) {
        ChildMethod childMethod = new ChildMethod();
        childMethod.test();
    }
}
