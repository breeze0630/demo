package com.example.hot.hot39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     *
     *
     * 先排序，如果最小的 > target == > null
     * 找出小于等于 target 的部分，作为新数组来组合结果
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        int max = 0;
        while ( max < candidates.length){
            if(candidates[max] <= target){
                max++;
            }
        }

        if(max == 0 && candidates[0] > target){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        int[] nums = Arrays.copyOf(candidates,max);
        int len = 1;
        while (len <= nums.length){



            len++;
        }

        return res;
    }

}
