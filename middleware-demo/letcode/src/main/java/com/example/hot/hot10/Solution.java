package com.example.hot.hot10;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch1("ab",".*c")); // false
        System.out.println(new Solution().isMatch1("aaa","a*a")); //true
        System.out.println(new Solution().isMatch("aa","a*")); //true
        System.out.println(new Solution().isMatch("aa","a")); //false
        System.out.println(new Solution().isMatch("aaa","aaaa")); //false
        System.out.println(new Solution().isMatch("aaa","ab*a*c*a")); //true
        System.out.println(new Solution().isMatch("a","ab*")); //true
        long start = System.currentTimeMillis();
        System.out.println(new Solution().isMatch("a",".*..a*")); //true
        System.out.println(System.currentTimeMillis() - start);


    }

    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


        public boolean isMatch(String param, String p) {
        char[] chars = p.toCharArray();
        int index = 0;
        String s = param;
        while (s.length() > 0 && index < chars.length){

            char left = chars[index];
            char right = index + 1 < chars.length ? chars[index + 1] : ' ';

            boolean patten = right == '*';

            if(patten){
                while (true){
                    if(s.length() == 0){
                        break;
                    }else if(s.startsWith(String.valueOf(left)) || left == '.' ){
                        s = s.substring(1);
                    }else if(!s.startsWith(String.valueOf(left))){
                        break;
                    }
                }
                index ++ ;
            }else {
                if(left == '.'){
                    s = s.substring(1);
                }else if(s.startsWith(String.valueOf(left))){
                   s= s.substring(1);
               } else {
                   return false;
               }
            }
            index++;
        }
        String right = new String(Arrays.copyOfRange(chars,index,chars.length));
        while (right.length()>1){
            if( ((right.charAt(0) >= 'a' && right.charAt(0) <= 'z' ) || right.charAt(0) == '.')  && right.charAt(1) == '*' ){
                right = right.substring(2);
            }else if(right.charAt(0) == '.' && right.charAt(1) != '*'){
                return false;
            }
        }
        if(s.length() == 0 && right.length()>0 ){
            String left = param.substring( param.length() - right.length()  > 0 ? param.length() - right.length() : 0);
            return (left.equals(right) && chars[index - 1] == '*' );
        }else if(s.length() > 0){
            return false;
        }
        return true;
    }
}
