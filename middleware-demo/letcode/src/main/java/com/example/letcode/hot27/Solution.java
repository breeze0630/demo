package com.example.letcode.hot27;

public class Solution {
    public int removeElement(int[] nums, int val) {

        int n = nums.length;
        if( n == 0){
            return n;
        }
        int size = 0;
        int i = 0;
        while (i < n){
            if( nums[i] != val ) {
                nums[size] = nums[i];
                size++;
            }
            i++;
        }
        return size;
    }
}
