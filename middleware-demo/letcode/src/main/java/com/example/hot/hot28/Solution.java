package com.example.hot.hot28;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello","ll"));
        System.out.println(new Solution().strStr("aa","aaaaa"));

    }
    public int strStr(String haystack, String needle) {

        int needleLen = needle.length() ;

        if(needleLen == 0){
            return needleLen;
        }
        int index = 0;
        int hayLen = haystack.length();
        char[] hayCharArr =  haystack.toCharArray();
        char[] needCharArr =  needle.toCharArray();

        for( ; index < hayLen;index++){
            int i = 0;
            if(index + needCharArr.length > hayLen){
                return -1;
            }
            while ( i < needCharArr.length){
                if( needCharArr[i] != hayCharArr[index+i] ){
                    break;
                }
                i++;
            }
            if(i == needCharArr.length){
                return index;
            }
        }
        return -1;
    }
}
