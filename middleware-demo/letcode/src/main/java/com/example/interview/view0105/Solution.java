package com.example.interview.view0105;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().oneEditAway("a","bc"));
    }
    public boolean oneEditAway(String first, String second) {

        if(first == null && second == null){
            return false;
        }

        if(Math.abs(first.length()-second.length()) > 1){
            return false;
        }

        int i = 0,j=0;
        boolean has = false;
        while (i < first.length() && j < second.length()){
            if(first.charAt(i) == second.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(has){
                return false;
            }
            has = true;
            if(first.length() == second.length()){
                i++;j++;
            }else if(first.length()>second.length()){
                i++;
            }else{
                j++;
            }
        }

        return true;
    }


}
