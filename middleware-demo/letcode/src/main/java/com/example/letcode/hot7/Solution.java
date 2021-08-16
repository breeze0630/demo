package com.example.letcode.hot7;

/**
 * @author: liubiao
 * @date: 2021/8/16 21:22
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().reverse(1534236469) );
        System.out.println(new Solution().reverse1(1534236469) );


    }
    public int reverse(int x) {

        int positive = x >= 0 ? 1 : -1;
        String xString = String.valueOf(Math.abs(x));
        String xRet =  new StringBuilder(xString).reverse().toString();
        try {
            return positive * Integer.valueOf(xRet);
        }catch (NumberFormatException e){
            return 0;
        }

    }


    public int reverse1(int x) {

        int rev = 0;
        while (x != 0){
            if( rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10 ){
                return 0;
            }

            int dist = x % 10;
            x /= 10;
            rev = rev * 10 + dist;
        }

        return rev;
    }
}
