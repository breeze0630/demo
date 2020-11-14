package com.example.springlearndemo.jdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/14 17:17
 * @Create by external_ll@163.com
 **/
public class RamdomTest {
    public static void main(String[] args) {
        Random random = new Random();
        HashMap<Integer,Integer> result = new HashMap<>();
        int max = 10000;
        while (max>0){
            int current =( int )(Math.random()*100)+1;
            if(result.get(current) != null ){
                result.put(current,result.get(current)+1);
            }else {
                result.put(current,1);
            }
            max--;
        }
        double maxPercent = 0;
        double minPercent = 0;
        for (Map.Entry<Integer,Integer> entry:result.entrySet()) {
            double curPercent = entry.getValue()*1.0/10000;
            System.out.println("entry key :" +entry.getKey() + " : " + curPercent);
            if(curPercent>maxPercent) maxPercent = curPercent;
            if(curPercent<minPercent) minPercent = curPercent;
        }
        System.out.println("percent : " + (maxPercent - minPercent));
    }
}
