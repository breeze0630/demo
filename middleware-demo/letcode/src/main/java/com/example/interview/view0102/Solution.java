package com.example.interview.view0102;

public class Solution {

    public static void main(String[] args) {


        System.out.println(new Solution().CheckPermutation("asvnpzurz","urzsapzvn"));
        System.out.println(new Solution().CheckPermutation("abc","bad"));
        System.out.println(new Solution().CheckPermutation("abc","bac"));

    }

    /**
     * 冒泡排序
     * @param s1
     * @param s2
     * @return
     */

    /*public boolean CheckPermutation(String s1, String s2) {
        if(s1 == null || s2 ==null){
            return false;
        }

        if(s1.length() != s2.length()){
            return false;
        }

        char[] char1 = s1.toCharArray();

        for(int i = 0 ; i < char1.length - 1 ; i++ ){
            for( int j = i + 1 ; j < char1.length; j++){
                if( char1[i] > char1[j]){
                    char c = char1[j];
                    char1[j] = char1[i];
                    char1[i] = c;
                }
            }
        }
        char[] char2 = s2.toCharArray();

        for(int i = 0 ; i < char2.length - 1 ; i++ ){
            for( int j = i + 1 ; j < char2.length; j++){
                if( char2[i] > char2[j]){
                    char c = char2[j];
                    char2[j] = char2[i];
                    char2[i] = c;
                }
            }
        }
        return String.valueOf(char1).equals(String.valueOf(char2));
    }*/

    /**
     * 二分法快排
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if(s1 == null || s2 ==null){
            return false;
        }

        if(s1.length() != s2.length()){
            return false;
        }

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        quickSort(char1,0,char1.length-1);
        quickSort(char2,0,char2.length-1);

        return String.valueOf(char1).equals(String.valueOf(char2));
    }


    public void quickSort(char[] chars,int left ,int right){
        if(left > right)
        {
            return;
        }
        char base = chars[left];
        int i = left,j = right;
        while ( i != j ){
            while ( chars[j] >= base && i < j){
                j--;
            }
            while (chars[i] <= base && i < j){
                i++;
            }
            if(i < j){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }
        base = chars[left];
        chars[left] = chars[i];
        chars[i] = base;

        quickSort(chars,left,i-1);
        quickSort(chars,i+1,right);
    }
}
