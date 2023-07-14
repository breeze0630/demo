package com.example.hot.hot40;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/13
 */
public class Solution {

    public static void main(String[] args) {
        int[] a1 = new int[]{10, 1, 2, 7, 6, 1, 5};
        Solution solution = new Solution();
        System.out.println(JSON.toJSONString(solution.combinationSum2(a1, 8)));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tem = new ArrayList<>();
        int left = candidates[0];
        tem.add(left);
        for (Integer can : candidates) {
            if (can.equals(left)) {
                continue;
            } else {
                left = can;
                tem.add(can);
            }
        }


        Integer[] cans = tem.toArray(new Integer[0]);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(cans, target, res, nums, 0);
        return res;
    }

    private void dfs(Integer[] candidates, int target, List<List<Integer>> res, List<Integer> nums, int ids) {
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        if (ids == candidates.length) {
            return;
        }

        dfs(candidates, target, res, nums, ids + 1);
        if (target - candidates[ids] >= 0) {
            nums.add(candidates[ids]);
            dfs(candidates, target - candidates[ids], res, nums, ids);
            nums.remove(nums.size() - 1);
        }
    }


}
