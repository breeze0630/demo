package com.example.interview.view0106;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().compressString("aabcccccaaa"));
        System.out.println(new Solution().compressString("abbccd"));
        System.out.println(new Solution().compressString("bb"));
    }
    public String compressString(String S) {
        if(S == null || S.length() == 0 ){
            return S;
        }

        int left = 0;
        char[] chars = S.toCharArray();
        String news = "";
        while (left < chars.length){
            int right = left;
            int num = 0;
            while (right < chars.length){
                if(chars[left] == chars[right]){
                    num++;
                }else {
                    news = news + chars[left] + num;
                    left = right ;
                    break;
                }
                right++;
            }
            if(right == chars.length){
                news = news + chars[left] + num;
                break;
            }

        }
        return news.length() < S.length() ? news : S;
    }
    public String compressString2(String S) {
        if(S == null || S.length() == 0 ){
            return S;
        }

        int left = 0;
//        char[] chars = S.toCharArray();
        StringBuilder news = new StringBuilder();
        while (left < S.length()){
            int right = left;
            int num = 0;
            while (right < S.length()){
                if(S.charAt(left) == S.charAt(right)){
                    num++;
                }else {
                    news.append(S.charAt(left)).append(num);
                    left = right ;
                    break;
                }
                right++;
            }
            if(right == S.length()){
                news.append(S.charAt(left)).append(num);
                break;
            }

        }
        return news.length() < S.length() ? news.toString() : S;
    }

    public String compressString1(String S) {
        if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }


/*
    public String compressString(String S) {
        if(S == null || S.length() == 0 ){
            return S;
        }
        char[] chars = S.toCharArray();
        int i = 1;
        char tmp = chars[0];
        int num = 1;
        String news = "";

        while ( i < chars.length){
            if( chars[i] == tmp ){
                num++;
            }else {
                news = news + tmp + num;
                tmp = chars[i];
                num = 1;
            }
            i++;
        }

        if( num > 0 ){
            news = news + tmp + num;
        }

        return news.length() < S.length() ? news : S;
    }*/
}
