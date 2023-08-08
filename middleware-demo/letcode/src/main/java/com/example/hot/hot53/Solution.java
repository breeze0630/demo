package com.example.hot.hot53;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/10
 */
public class Solution {

    public static void main(String[] args) {

        int[] ints = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(ints));
//        System.out.println(solution.maxSubArray(new int[]{-2,-1}));

    }

    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int max = sum;
        if (nums.length == 1) {
            return sum;
        }
        while (left <= right) {
            if (nums[left] < nums[right]) {
                sum -= nums[left];
                max = Math.max(sum, max);
                left++;
            } else if (nums[left] > nums[right]) {
                sum -= nums[right];
                max = Math.max(sum, max);
                right--;
            } else {
                //等于的场景
                if(left == right){
                    left++;
                }else {

                    int l = sum - nums[left + 1] - nums[left];
                    int r = sum - nums[right - 1] - nums[right];
                    max = Math.max(max, Math.max(l, r));
                    if (l < r) {
                        right = right - 2;
                    } else if (l > r) {
                        left = left + 2;
                    } else {
                        left++;
                        right--;
                    }
                }
            }
        }
        return max;
    }
}
