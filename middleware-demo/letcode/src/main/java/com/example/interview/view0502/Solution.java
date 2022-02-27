package com.example.interview.view0502;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().printBin(0.375));
        System.out.println(new Solution().printBin(0.1));

    }
    public String printBin(double num) {
        int count = 30;
        List<Integer> list = new LinkedList<>();
        while (count > 0){
            if( num == 0 ){
                break;
            }
            double tmp = num * 2;
            list.add(tmp >= 1 ? 1 : 0);
            num = tmp >= 1 ? tmp - 1 : tmp;
            count--;
        }
        if(count == 0 && num != 0){
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        for(int k = 0 ; k < list.size(); k++){
            sb.append(list.get(k));
        }
        return sb.toString();
    }




}
