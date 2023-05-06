package com.example.hot.hot29;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().divide(10,3));
//        System.out.println(new Solution().divide(7,-3));
        System.out.println(new Solution().divide(-2147483648,-1));

    }

    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int fuhao = 1;


        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            fuhao = 1;
        } else {
            fuhao = -1;
        }
        int tmp = 0;
        if(dividend == Integer.MIN_VALUE){
            dividend += 1;
            tmp = 1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int res = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            res++;
        }

        if(dividend + tmp >= divisor){
            res++;
        }

        return fuhao > 0 ? res : 0 - res;
    }
}
