package com.example.interview.view0101;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().isUnique("leetcode"));
        System.out.println(new Solution().isUnique("abc"));

    }

    public boolean isUnique(String astr) {

        List<Character> charSet = new ArrayList<>();
        char[] chars = astr.toCharArray();
        int i = 0;
        while (i<chars.length){
            if(charSet.contains(chars[i])){
                return false;
            }
            charSet.add(chars[i]);
            i++;
        }
        return true;
    }
}
