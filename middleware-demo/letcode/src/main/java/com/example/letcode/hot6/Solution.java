package com.example.letcode.hot6;

public class Solution {

    public static void main(String[] args) {
        System.out.println("AB".equals(new Solution().convert("AB",1)));
    }
    public String convert(String s, int numRows) {

        if(s.length() <= numRows || numRows == 1){
            return s;
        }

        StringBuilder[] chars = new StringBuilder[numRows];
        for( int i = 0 ; i<numRows;i++){
            chars[i] = new StringBuilder();
        }
        int index = 0;
        int len = 2 * numRows - 2 ;
        while ( index < s.length() ){
            int index1 = index % len;
            if(index1 < numRows){
                chars[index1].append(s.substring(index,index+1));
            }else {
                chars[len-index1].append(s.substring(index,index+1));
            }
            index++;
        }

        String result = "";
        for(int i = 0 ; i < chars.length;i++)
        {
            result += chars[i].toString();
        }
        return result;
    }
}
