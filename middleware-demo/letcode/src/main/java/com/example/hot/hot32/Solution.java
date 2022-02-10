package com.example.hot.hot32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {


    public static void main(String[] args) {
        new Solution().longestValidParentheses("(())(())");
    }

    /**
     * 使用队列
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 这里是当出现额外的右括号时，说明前面的都已经完全匹配完，需要将当前的坐标压栈，当前坐标作为初始值
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
