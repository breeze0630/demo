package com.example.interview.view3;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        System.out.println(new Solution().replaceSpaces("Mr John Smith    ",13));
        System.out.println(new Solution().replaceSpaces("               ",5));

    }

    public String replaceSpaces(String S, int length) {
        if(S.length() > length){
            S = S.substring(0,length);
        }
        return S.replaceAll(" ","%20");
    }


}
