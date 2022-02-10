package com.example.hot.hot11;

public class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().maxArea( new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(System.currentTimeMillis() - start);
    }
    public int maxArea(int[] height) {

        int max = 0;
        int left = 0;
        while (left <= height.length-2){
            int right = left + 1;
            while (right <= height.length - 1){
                max = Math.max((right - left) * Math.min(height[left],height[right]), max );
                right++;
            }
            left++;
        }

        return max;
    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
