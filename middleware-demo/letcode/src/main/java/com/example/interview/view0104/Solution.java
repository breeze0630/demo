package com.example.interview.view0104;

import java.util.HashMap;
import java.util.Map;

/***
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canPermutePalindrome("code"));
    }
    public boolean canPermutePalindrome(String s) {

        if(s == null || s.length() == 0){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        while ( i < s.length()){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
            i++;
        }

        boolean has = false;
        for (Map.Entry<Character,Integer> entry: map.entrySet() ) {
            if(entry.getValue() % 2 != 0 && has){
                return false;
            }else if(entry.getValue() % 2 != 0){
                has = true;
            }
        }
        return true;
    }

}
