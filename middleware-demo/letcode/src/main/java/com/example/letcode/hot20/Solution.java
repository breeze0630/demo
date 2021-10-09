package com.example.letcode.hot20;

import java.util.LinkedList;

/**
 * @author: liubiao
 * @date: 2021/9/11 16:28
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isValid("}{"));
    }
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        LinkedList<Character> characters = new LinkedList<>();
        for( char c : s.toCharArray()){
            if(characters.size() <= 0){
                characters.add(c);
                continue;
            }else{
                char c2 = characters.pollLast();
                if(!isPattern(c2,c)){
                    characters.add(c2);
                    characters.add(c);
                }

            }
        }
        return characters.size() == 0;
    }

    public boolean isPattern(char left,char right){
        return  (left == '(' && right == ')' ) || (left == '[' && right == ']' ) || (left == '{' && right == '}' );
    }

}
