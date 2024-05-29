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

    public static void main(String[] args) {

        mapping();
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
