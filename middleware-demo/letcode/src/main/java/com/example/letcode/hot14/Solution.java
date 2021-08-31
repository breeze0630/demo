package com.example.letcode.hot14;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {"abab","aba",""}));
    }
    public String longestCommonPrefix(String[] strs) {

        String result = "";
        int minLen = Integer.MAX_VALUE;
        for(int left = 0; left < (strs.length + 1)/2;left++){
            minLen = Math.min(minLen, Math.min(strs[left].length(),strs[strs.length - 1 - left].length()));
        }
        for( int i = 0; i < minLen ; i++){
            char lin = strs[0].charAt(i);
            for(int left = 0; left < (strs.length + 1)/2;left++){
                if(strs[left].charAt(i) == (strs[strs.length - 1- left].charAt(i)) && strs[left].charAt(i) == (lin)){
                    continue;
                }else {
                    return result;
                }
            }
            result = result+lin;
        }
        return result;
    }
}
