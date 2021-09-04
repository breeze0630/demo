package com.example.letcode.hot18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2},-9));
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
            /*if( nums[l1] > target){
            //这里不能判断，因为负数时是反过来的
                return  result;
            }*/
            for (int l2 = l1 + 1; l2 < n - 2; l2++) {
                if (l2 > l1 + 1 && nums[l2] == nums[l2 - 1]) {
                    continue;
                }
                /*if( nums[l1] + nums[l2] > target){
                //这里不能判断，因为负数时是反过来的
                    l2++;
                    continue;
                }*/
                int r2 = l2 + 1, r1 = n - 1;
                while (r2 < r1) {
                    if(r2 > l2 + 1 && nums[r2] == nums[r2-1]){
                        r2++;
                        continue;
                    }
                    /*if( nums[l1] + nums[l2] + nums[r2]> target){
                    //这里不能判断，因为负数时是反过来的
                        break;
                    }*/
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
