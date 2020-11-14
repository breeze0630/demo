package com.example.springlearndemo.kaoshi;

import java.util.ArrayList;
import java.util.List;

public class T5 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int index = 1 ; index <=500 ; index++){

            int current = index;
            int sum = 0;
            for(int i = 1;i <= current/2;i++){
                if(current%i == 0){
                    sum += i;
                }
            }
            if(sum == current){
                list.add(current);
            }
        }
        System.out.println(list.toString());
    }
}
