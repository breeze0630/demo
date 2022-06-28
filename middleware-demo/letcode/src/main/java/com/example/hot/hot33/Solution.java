package com.example.hot.hot33;

public class Solution {


    public static void main(String[] args) {
        System.out.println( new Solution().search2(new int[]{4,5,6,7,0,1,2},3));
    }

    // 最直接的解题思路便是遍历
    public int search(int[] nums, int target) {

        int i = 0, len = nums.length;
        while (i <= len - 1){
            if(nums[i] == target){
                return i;
            }
            i++;
        }
        return -1;
    }

    public int search2(int[] nums,int target){

        int left = 0 , right = nums.length - 1;
        while ( left <= right){
            if(target == nums[left]){
                return left;
            }else if( target == nums[right]){
                return right;
            }else if( target < nums[left] && target > nums[right]){
                return -1;
            }

            if( target > nums[left]){
                left++;
            }
            if( target < nums[right]){
                right--;
            }
        }
        return -1;
    }
}
