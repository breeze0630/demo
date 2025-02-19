package com.breeze.sample.elasticsearchdemoparent;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @auther: liubiao
 * @date: 2025-02-18
 */
public class TestOOM {

    public static void main(String[] args) {

       new Thread(new Runnable(){
            @Override
            public void run() {
                new TestOOM().forTest();
            }
        }).start();


    }

    public  void forTest() {

        List<ClassA> list = new LinkedList<>();
        for(int id = 1 ; id > 0; id ++){
            ClassA obj = new ClassA();
            obj.setId(id);
            obj.setName("name_"+id);
            list.add(obj);
            if(id == Integer.MAX_VALUE){
                id = 1;
            }
        }
    }


    @Data
    class ClassA{
        public int id;
        private String name;
    }

}
