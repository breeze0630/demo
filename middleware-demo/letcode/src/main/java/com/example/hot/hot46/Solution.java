package com.example.hot.hot46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return res;
        }

        if( nums.length == 1){
            res.add(Arrays.asList(nums[0]));
            return res;
        }
        boolean[] used = new boolean[nums.length];

        dfs(nums,new ArrayList(),res,used,0);
        return res;
    }

    private void dfs(int[] nums,List<Integer> added , List<List<Integer>> res , boolean[] used,int len){
        if(len  == nums.length){
            List<Integer> news = added.stream().collect(Collectors.toList());
            res.add(news);
            return;
        }

        for( int i = 0 ; i < nums.length ; i++ ){
            if( !used[i] ){
                added.add(nums[i]) ;
                used[i] = true;
                dfs(nums,added,res,used,len+1);
                //清除当前节点(撤销选择)
                used[i] = false;
                added.remove(added.size()-1);
            }
        }
    }
}
