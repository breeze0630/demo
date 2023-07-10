package com.example.hot.hot49;

import java.util.*;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/10
 */
public class Solution {


    public static void main(String[] args) {

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(strs).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(new String(chars),new ArrayList<>());
            list.add(str);
            map.put(new String(chars),list);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
