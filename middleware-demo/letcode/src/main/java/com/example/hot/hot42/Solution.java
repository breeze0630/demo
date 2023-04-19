package com.example.hot.hot42;

public class Solution {

    public int trap(int[] height) {

        int total = 0;

        int temp = 0;
        int left  = 0;
        int right = 0;

        while ( left == height.length ){
            if(height[left] == 0 ){
                left = right + 1;
                right = left;
                continue;
            }
            if(height[left] < height[right] && right - left == 1){
                left = right + 1;
                right = left;
                continue;
            }



        }

        return total;
    }


}
