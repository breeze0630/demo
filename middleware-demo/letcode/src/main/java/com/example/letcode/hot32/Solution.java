package com.example.letcode.hot32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s
     * @return
     */


    public int longestValidParentheses(String s) {

        if(s.length() == 0){
            return 0;
        }

        Deque<Integer> stack = new LinkedList<Integer>();

        int size = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 1 ;
        while ( i < len ){

        }

        return 0;
    }

    public boolean isPattern(Character left , Character right){
        return left.equals('(') && right.equals(')');
    }
}
