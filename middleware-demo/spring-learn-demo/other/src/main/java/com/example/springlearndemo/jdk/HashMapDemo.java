package com.example.springlearndemo.jdk;

import com.example.springlearndemo.function.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liubiao
 * @date: 2021/4/25 20:20
 * @Description:
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<Student,Object> hashMap = new HashMap<>();
        int max = 100;
        for(int i = 0 ; i< max; i++){
//            if(i >= 12){
            Student student = Student.builder().id(0).name("0").age(1).build();
            hashMap.put(student,true);
//            }else {
//                hashMap.put(String.valueOf(i),true);
//            }
        }
//        hashMap.put(String.valueOf(11),true);
//        hashMap.put(String.valueOf(11),true);

    }
}
