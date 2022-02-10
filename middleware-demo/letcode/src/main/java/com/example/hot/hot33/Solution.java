package com.example.hot.hot33;

public class Solution {


    public static void main(String[] args) {
        System.out.println( new Solution().search(new int[]{1,3},1));
    }

    public int search(int[] nums, int target) {

        int i = 0, len = nums.length;
        while (i < len - 1){
            if( nums[i] > nums[i+1] && nums[i+1] == target){
                return i+1;
            }
            i++;
        }
        return nums[len-1] == target ? len-1 : -1;
    }
}
