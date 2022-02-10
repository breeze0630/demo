package com.example.hot.hot5;

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


    public String longestPalindrome2(String s) {

        if(s.length()<=1){
            return s;
        }

        int len = s.length();


        char[] chars = s.toCharArray();
        boolean[][] result = new boolean[len][len];
        for(int i = 0 ; i < chars.length ; i++){
            result[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;

        for(int l = 2 ; l < len-1 ; l++){
            // i 为字符串的左边界
            for(int i = 0 ; i < len; i++){
                // j 字串符的右边界
                int j = i + l - 1;
                if(i >= len){
                    break;
                }


                if(chars[i] == chars[j]){
                    //最外层相同则判断内层,当前字符串长度 <= 3 时，直接可判断必定回文
                    if( j - i < 3 ){
                        result[i][j] = true;
                    }else {
                        //否则根据内层判断， 因为这里我们都是先判断字符串长度小的，所以当前字符串的内层一定已经判断过了
                        result[i][j] =  result[i+1][j-1];
                    }
                }

                if(result[i][j] && (j - i + 1) > maxLen ){
                    //当前回文 && 当前的字符串长度超过之前的
                    maxLen = j - i + 1;
                    begin = i;
                    //这里不能跳出，因为目前尚未确定最长的回文子串
                }
            }

        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome3(String s) {
        if(s.length()<=1){
            return s;
        }

        int start = 0, end= 0;

        //中心扩散
        // 中心点要么是 i ,要么是 i 和 i+1 ,所以这里遍历的时候，要同时扩散i , 和i+1 的两种情况，并比较
        for( int i = 0; i < s.length() ; i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len -1) / 2;
                end = i + len /2;
            }

        }

        return s.substring(start,end+1);
    }

    //因为结束循环时左右各自增了一次，所以实际的长度是 ( right - left + 1 ) - 2 ==> right - left - 1
    public int expandAroundCenter(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
