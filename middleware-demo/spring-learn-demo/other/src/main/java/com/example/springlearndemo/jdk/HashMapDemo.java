package com.example.springlearndemo.jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liubiao
 * @date: 2021/4/25 20:20
 * @Description:
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,Object> hashMap = new HashMap<>();
        int max = 10;
        for(int i = 0 ; i< max; i++){
//            if(i >= 12){
                hashMap.put(String.valueOf(i),true);
//            }else {
//                hashMap.put(String.valueOf(i),true);
//            }
        }
        hashMap.put(String.valueOf(11),true);
        hashMap.put(String.valueOf(11),true);

    }
}
