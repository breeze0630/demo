package com.example.interview.view0109;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isFlipedString("waterbottle","erbottlewat"));
        System.out.println(new Solution().isFlipedString("aa","aba"));
        System.out.println(new Solution().isFlipedString("",""));

    }

    public boolean isFlipedString(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }
        return (s2+s2 ).contains(s1);
    }



}
