package com.example.other.stream;

import com.alibaba.fastjson.JSON;
import com.example.other.dto.StudentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-28
 */

public class StreamDemo {

    public static void main(String[] args) throws  Exception{

        testSort();
    }

    private static void testSort() throws  Exception{
        System.out.println("------------------ SORT START ------------------");

        List<String> list = new ArrayList<>();
        int size = 10;
        for (int index = 0 ; index < size ; index++){
            list.add(index+"");
        }
        List<String> list1 = new ArrayList<>();
        List<String> list12 = list.parallelStream().map(k->{
            if(k.contains("5")){
                try {
                    Thread.sleep(3000);
                }catch ( Exception e){

                }
            }
            if(k.contains("2")){
                try {
                    Thread.sleep(9000);
                }catch ( Exception e){

                }
            }
            list1.add(k);
            return k;
        }).collect(Collectors.toList());


        System.out.println(JSON.toJSONString(list12));
        System.out.println(JSON.toJSONString(list1));

        System.out.println("------------------- SORT END --------------");

    }

    private static void mapping(){
        System.out.println("----------------- Collectors.mapping() start ----------------");
        int size = 10 ;
        List<StudentInfo> studentInfoList = new ArrayList<>();
        for(int index = 0 ; index < size ; index++){
           StudentInfo studentInfo = StudentInfo.builder().id(index).name("name"+index).age(index).build();
           studentInfoList.add(studentInfo);
        }
        List<String> nameList = studentInfoList.stream()
                        .collect(Collectors.mapping(StudentInfo::getName,Collectors.toList()));
        System.out.println(JSON.toJSONString(nameList));
        System.out.println("----------------- Collectors.mapping() end ----------------");
    }
}
