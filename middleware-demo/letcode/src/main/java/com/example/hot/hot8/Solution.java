package com.example.hot.hot8;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: liubiao
 * @date: 2021/8/22 10:20
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Solution().myAtoi("-42 "));
        System.out.println(new Solution().myAtoi2("-42 "));

    }
    public int myAtoi(String s) {

        int result = 0 ;
        if(s == null|| s.length() <= 0){
            return result;
        }

        char[] chars = s.toCharArray();
        int index = 0;
        boolean isStart = true;
        Boolean posi = null;
        while (index < chars.length) {
            //去除前导空格
            char current = chars[index];
            if (isStart && current == ' ') {
                index++;
                continue;
            } else if (isStart && current != ' ') {
                isStart = false;
            }
            //有效字符第一位
            if (posi == null) {
                if (current == 43) {
                    posi = true;
                } else if (current == 45) {
                    posi = false;
                } else if (current >= 48 && current <= 57) {
                    posi = true;
                    result = current - 48;
                } else {
                    return result;
                }
            } else if (current < 48 || current > 57) {
                return result;
            } else {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (current - 48) > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (current - 48) > -1 * (Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                result = posi ? (result * 10) + (current - 48) : (result * 10) - (current - 48);
            }
            index++;
        }
        return result;
    }

    public int myAtoi2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }


}





//DFA 解法，根据字符串的传入，逐渐修改状态，直到结束 end
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
