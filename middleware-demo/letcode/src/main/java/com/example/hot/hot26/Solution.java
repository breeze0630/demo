package com.example.hot.hot26;

public class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n <= 1){
            return n;
        }
        int yd = 1,end = 1;
        while ( yd < n){
            if(nums[yd] != nums[yd-1]){
                nums[end] = nums[yd];
                end++;
            }
            yd++;
        }
        return end;
    }
}
