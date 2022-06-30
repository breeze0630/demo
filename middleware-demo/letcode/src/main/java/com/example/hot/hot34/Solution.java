package com.example.hot.hot34;

public class Solution {

    public int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length -1;
        int l1 = -1 ; int r1 = -1;

        while ( l <= r && (l1 + r1) < -2){
            if(nums[l] == target){
                l1 = l;
            }else {
                l++;
            }
            if(nums[r] == target){
                r1 =  r;
            }else {
                r--;
            }

        }

        return new int[]{l1,r1};
    }

    /**
     * 二分法
     * 2次二分
     * 第一次二分，获得第一个大于等于 target 的 下标，
     * 第二次二分，获得第一个大于 target 的下标
     * 所以第二次二分的下标需要-1，
     * 最后检验2个下标是否合理，不合理返回{-1,-1}
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {

        int l = getIndex(nums,target,true);
        int r = getIndex(nums,target,false) - 1 ;

        return l <= r && r < nums.length && nums[l] == target && nums[r] == target ? new int[]{l,r} : new int[]{-1,-1};
    }

    public int getIndex(int[] nums,int target,boolean lower) {
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || ( lower && nums[mid] >= target)) {
                r = mid - 1;
                index = mid;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
