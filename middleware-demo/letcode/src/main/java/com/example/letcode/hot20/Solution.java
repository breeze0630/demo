package com.example.letcode.hot20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: liubiao
 * @date: 2021/9/11 16:28
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isValid("(([]){})"));
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid(String s) {

        if(s.length() == 0){
            return true;
        }
        if(s.length()==1){
            return false;
        }

        return false;
    }

    public boolean isPattern(String left,String right){

            return (left.equals("(") && right.equals(")")) || (left.equals("{") && right.equals("}"))
                    || (left.equals("[") && right.equals("]"));
    }
}
