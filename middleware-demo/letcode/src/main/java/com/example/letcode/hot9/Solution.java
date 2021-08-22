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
        int shang = x;
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
}
