package com.example.letcode.hot16;

import java.net.Inet4Address;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int first = 0;
        int n = nums.length ;
        int sum = Integer.MIN_VALUE;
        for( ; first <= n - 3;first++){
            int second = first + 1;
            for( ; second <= n - 2 ; second ++ ){
                int third = n - 1;
                while ( third > second ){
                    int sumMin = Math.abs(target - ( nums[first] + nums[second] + nums[third])) ;
                    min = sumMin < min ? sumMin : min;
                    sum =  sumMin < min ? nums[first] + nums[second] + nums[third] : sum;
                    third--;
                }

            }
        }
        return sum;
    }
}
