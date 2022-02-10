package com.example.hot.hot1;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,6,2,41,2,5};
        int[] tag = new Solution().twoSum(nums,4);
        System.out.println(JSON.toJSON(nums));
        System.out.println(JSON.toJSON(tag));

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                //找到的时候，肯定是 num[i] 的坐标大
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
    public int[] twoSum1(int[] nums, int target) {
        int[]  copy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        if(target > copy[copy.length-1] + copy[copy.length-2]){
            return null;
        }
        if(target < copy[0]){
            return null;
        }

        int total = nums.length;
        for( int i = 0 ; i < total-1 ; i++ ){
            for( int j = i + 1 ; j < total ; j++){
                if(nums[i] + nums[j] == target){
                    int[] tag = {i,j};
                    return tag;
                }
            }
        }
        return null;
    }
}
