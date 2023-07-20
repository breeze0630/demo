package com.example.hot.hot45;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/19
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
        long start = System.currentTimeMillis();
//        System.out.println(solution.jump(new int[]{5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0}));
        System.out.println(System.currentTimeMillis() - start);
    }
    // TODO 待完成
    public int jump(int[] nums) {

        int index = 0 ;
        int step = 0;
        while (index < nums.length){

            int i = nums[index];
            int start = index;
            int max = -1;
            while ( start <= i ){
                max = Math.max( start + nums[start] ,max);
                start++;
            }




        }
        return step;

    }


}
