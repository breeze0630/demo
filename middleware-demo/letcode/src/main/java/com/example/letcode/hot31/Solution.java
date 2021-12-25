package com.example.letcode.hot31;

import com.alibaba.fastjson.JSON;


public class Solution {

    public static void main(String[] args) {

        int[] intArr = new int[]{4,5,3,6,2,1};
        new Solution().nextPermutation(intArr);
        System.out.println(JSON.toJSONString(intArr));
        int[] intArr1 = new int[]{1,2,3};
        new Solution().nextPermutation(intArr1);
        System.out.println(JSON.toJSONString(intArr1));
    }

    public void nextPermutation(int[] nums) {


        int len = nums.length;
        if(len == 1){
            return;
        }

        int i = len-2;
        while (i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }

        if(i>=0) {
            int j = len - 1;
            while (j>=0) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    break;
                }
                j--;
            }
        }

        reverse(nums,i+1,len-1);

    }

    public void reverse(int[] nums,int left,int right){
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }




    /**
     * return 是否已交换过
     * @param nums
     * @param left
     * @return
     */
    public void swap(int[] nums,int left,int right){
                int k = nums[left];
                nums[left] = nums[right];
                nums[right] = k;

    }

}
