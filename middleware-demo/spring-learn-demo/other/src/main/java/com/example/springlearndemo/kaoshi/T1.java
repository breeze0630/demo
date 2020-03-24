package com.example.springlearndemo.kaoshi;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * 输入制筛子的次数
         * */

        System.out.println("输入投掷次数：");
        int num = scanner.nextInt();

        int index = 0;
        Random random = new Random();
        HashMap<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
        while (index<num){
            int resultNum1 = random.nextInt(6)+1;
            int resultNum2 = random.nextInt(6)+1;
            if(resultMap.get(resultNum1+resultNum2) == null){
                resultMap.put(resultNum1+resultNum2,1);
            }else {
                resultMap.put(resultNum1+resultNum2,resultMap.get(resultNum1+resultNum2)+1);
            }
            index++;
        }
        if(resultMap.size() > 0){
            for(Map.Entry<Integer, Integer> entry : resultMap.entrySet()){
                System.out.printf("和为 %s 的概率为: %s\n",entry.getKey(),entry.getValue()*1.0/num);
            }
        }else {
            System.out.println("本次操作无正常输出结果");
        }
        scanner.close();
    }
}
