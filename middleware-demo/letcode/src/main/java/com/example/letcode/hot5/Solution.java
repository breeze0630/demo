package com.example.letcode.hot5;

/**
 * @author: liubiao
 * @date: 2021/8/13 16:51
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().longestPalindrome("bb"));

        System.out.println(System.currentTimeMillis()-start);
    }

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }
        String maxStr = "";
        int length = s.length();

        int index = 0;
        while (index < length) {
            while (maxStr.length() > length - index) {
                break;
            }
            int size = length - index ;
            while (index + size <= length) {
                String inner = s.substring(index, index + size);
                if(maxStr.length() >= inner.length()){
                    break;
                }
                int offset = 0;
                boolean flag = true;
                while (offset < (size + 1) / 2) {
//                    System.out.printf("index:%s size:%s offset:%s \n", index, size, offset);
                    if (inner.charAt(offset) != inner.charAt(inner.length() - 1 - offset)) {
                        flag = false;
                        break;
                    }
                    offset++;
                }
                if (flag && inner.length() > maxStr.length()) {
                    maxStr = inner;
                }
                size--;

            }

            index++;
        }
        return maxStr;
    }
}
