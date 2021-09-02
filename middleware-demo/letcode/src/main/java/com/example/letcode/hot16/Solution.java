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
                    sum =  sumMin < min ? nums[first] + nums[second] + nums[third] : sum;
                    min = sumMin < min ? sumMin : min;
                    if(min == 0){
                        return sum;
                    }
                    third--;
                }

            }
        }
        return sum;
    }
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int first = 0;
        int n = nums.length ;
        int sum = Integer.MIN_VALUE;
        for( ; first <= n - 3;first++){
            int second = first + 1;
                int third = n - 1;
                while ( third > second ){
                    int sumInner  = nums[first] + nums[second] + nums[third];
                    if(sumInner == target){
                        return sumInner;
                    }
                    if(Math.abs(target-sumInner) < Math.abs( target -  sum)){
                        sum = sumInner;
                    }

                    if(min == 0){
                        return sum;
                    }
                    third--;
                }
        }
        return sum;
    }

    /**
     * 官方题解
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;

    }
}
