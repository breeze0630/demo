package com.example.letcode.hot9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liubiao
 * @date: 2021/8/22 20:51
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(10));

    }
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if( x <= 9){
            return true;
        }
        List<Integer> xList = new ArrayList<>();
        while ( x != 0){
            xList.add(x % 10);
            x = x / 10;
        }
        int i = 0;
        while ( i < (xList.size()+1 )/ 2){
            if(xList.get(i) != xList.get(xList.size() - 1 - i)){
                return false;
            }
            i++;
        }
        return true;
    }

    //官方题解
    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        // || 是 x 和  revertedNumber 的位数可能不一样，长度不同时说明 x 的位数小于 revertedNumber,只需要对比下相同位数部分的是否相同
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
