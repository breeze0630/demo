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

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(candidates,target,res,nums,0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> nums,int ids) {
        if(target == 0){
            res.add(new ArrayList<>(nums));
            return;
        }
        if( ids == candidates.length ){
            return;
        }

        dfs(candidates,target,res,nums,ids+1);
        if(target - candidates[ids] >= 0){
            nums.add(candidates[ids]);
            dfs(candidates,target-candidates[ids],res,nums,ids);
            nums.remove(nums.size() - 1 );
        }
    }

}
