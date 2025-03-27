package com.example.other;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther: liubiao
 * @date: 2025-03-26
 */
public class TestScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        // [[1,2,3,4],['a','b','c',1]]
        //[[1,2,3,4],[a,b,c,1]]
        String[] arr = str.split("],\\[");
        String arrStr1 = arr[0].replace("[[","");
        String arrStr2 = arr[1].replace("]]","");
        String[] arr1 = arrStr1.split(",");
        String[] arr2 = arrStr2.split(",");

        int length1 = arr1.length;
        int length2 = arr2.length;
        int length = length1 + length2;
        String[] res = new String[length];
        for(int i = 0 ; i<length1;i++){
            res[i] = arr1[i];
        }
        for(int i = 0 ; i < length2 ; i++){
            res[length1+i] = arr2[i];
        }

        System.out.println(JSON.toJSONString(res));

    }
}
