package com.example.letcode.hot18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().fourSum(new int[]{2,2,2,2,2},8));
        System.out.println(System.currentTimeMillis() - start);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int l1 = 0;
        for (; l1 < n - 3; l1++) {
            if (l1 > 0 && nums[l1] == nums[l1 - 1]) {
                continue;
            }
            if( nums[l1] > target){
                return  result;
            }
            for (int l2 = l1 + 1; l2 < n - 2; l2++) {
                if (l2 > l1 + 1 && nums[l2] == nums[l2 - 1]) {
                    continue;
                }
                if( nums[l1] + nums[l2] > target){
                    return  result;
                }
                int r2 = l2 + 1, r1 = n - 1;
                while (r2 < r1) {
                    if( nums[l1] + nums[l2] + nums[r2]> target){
                        return  result;
                    }
                    int sum = nums[l1] + nums[l2] + nums[r2] + nums[r1];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[l1], nums[l2], nums[r2], nums[r1]));
                        r2++;
                    } else if (sum < target) {
                        r2++;
                    } else if (sum > target) {
                        r1--;
                    }
                }
            }
        }

        return result;
    }
}
