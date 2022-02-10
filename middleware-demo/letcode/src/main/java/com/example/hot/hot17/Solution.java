package com.example.hot.hot17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
    }
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        String[] strs = new String[digits.length()];
        int index = 0 ;
        while ( index < digits.length()){
            strs[index] = getStr2(digits.charAt(index));
            index++;
        }

        check(strs,"",result);
        return result;
    }

    public void check(String[] chars,String s,List<String> list){
        if(chars.length == 0 ){
            if(!"".equals(s))
                list.add(s);
            return;
        }
        for(char c: chars[0].toCharArray()) {
            check(Arrays.copyOfRange(chars, 1, chars.length ), s+""+c, list);
        }
    }


    public char[] getStr(char digit){
        switch (digit){
            case '2':
                return "abc".toCharArray();
            case '3':
                return "def".toCharArray();
            case '4':
                return "ghi".toCharArray();
            case '5':
                return "jkl".toCharArray();
            case '6':
                return "mno".toCharArray();
            case '7':
                return "pqrs".toCharArray();
            case '8':
                return "tuv".toCharArray();
            case '9':
                return "wxyz".toCharArray();
        }
        return null;
    }

    public String getStr2(char digit){
        switch (digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return null;
    }
}
