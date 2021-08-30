package com.example.letcode.hot12;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println( new Solution().intToRoman(1994));
    }
    /**
     *
     *   I， V， X，  L， C， D 和  M
     *   1  5   10   50  100  500  1000
     */

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        String[] title = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] intTitle = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};

        List<String> result = new ArrayList<>();
        int current = intTitle.length - 1;
        while ( num > 0 ){
            if(num - intTitle[current] < 0){
                current--;
                continue;
            }
            num = num - intTitle[current];
            sb.append(title[current]);
            if(num < intTitle[current]){
                current --;
            }
        }

        return sb.toString();
    }
}
