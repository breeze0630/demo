package com.example.letcode.hot8;


/**
 * @author: liubiao
 * @date: 2021/8/22 10:20
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Solution().myAtoi("-2147483647"));
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

        while (index < chars.length){

            //去除前导空格
            char current = chars[index];
            if(isStart && current == 32){
                index++;
                continue;
            }else if(isStart && current != 32){
                isStart = false;
            }

            //有效字符第一位
            if(posi ==  null){
                if(current == 43){
                    posi = true;
                }else if(current == 45){
                    posi = false;
                }else if(current >=48 && current <= 57){
                    posi = true;
                    result = current - 48;
                }else {
                    return result;
                }
            }else if(current < 48 || current > 57){
                return result;
            }else {
                if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (current-48) > Integer.MAX_VALUE %10)  ) {
                    return Integer.MAX_VALUE;
                }else if(result < Integer.MIN_VALUE / 10 || (result ==  Integer.MIN_VALUE / 10 && (current-48) > -1*(Integer.MIN_VALUE %10))){
                    return Integer.MIN_VALUE;
                }
                result = posi ? (result * 10 )+ (current - 48) : ( result * 10) - (current-48);

            }
            index ++ ;
        }


        return result;
    }
}
