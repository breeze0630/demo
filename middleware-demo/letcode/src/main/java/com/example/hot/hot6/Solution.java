package com.example.hot.hot6;

public class Solution {

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(new Solution().convert1("PAYPALISHIRING",3)));
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

    public String convert1(String s, int numRows) {

        if(s.length() <= numRows || numRows == 1){
            return s;
        }

        StringBuilder[] chars = new StringBuilder[numRows];
        for( int i = 0 ; i<numRows;i++){
            chars[i] = new StringBuilder();
        }
        boolean up = true;
        int currentRow = 0;
        for ( char c :  s.toCharArray() ){
            chars[currentRow].append(c);
           if( currentRow == 0 || currentRow == numRows - 1 )
               up = !up;

           currentRow = up ? currentRow - 1 : currentRow + 1;
        }

        String result = "";
        for(int i = 0 ; i < chars.length;i++)
        {
            result += chars[i].toString();
        }
        return result;
    }
}
