package com.example.letcode.hot4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
       int[] nums1 = {1}, nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0 , nums2Index = 0;
        List<Integer> resultList = new ArrayList<>();
        while (true){
                if(nums1Index <= nums1.length-1 && nums2Index <= nums2.length-1){
                    if( nums1[nums1Index] <= nums2[nums2Index] ){
                        resultList.add(nums1[nums1Index++]);
                    }else {
                        resultList.add(nums2[nums2Index++]);
                    }
                }else if( nums1Index > nums1.length-1 && nums2Index <= nums2.length-1 ){
                    resultList.add(nums2[nums2Index++]);
                }else if( nums1Index <= nums1.length-1 && nums2Index > nums2.length-1 ){
                    resultList.add(nums1[nums1Index++]);
                }else {
                    break;
                }
        }
        return (resultList.size() % 2 == 0) ?
                ( (double)resultList.get(resultList.size() / 2 ) + (double) resultList.get(resultList.size() / 2 - 1) ) / 2
                : Double.valueOf(resultList.get(resultList.size() / 2  ));

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int nums1Index = 0 , nums2Index = 0;
        List<Integer> resultList = new ArrayList<>();
        int left  = 0;
        int right  = nums2.length;

        while (true){
            if(nums1Index <= nums1.length-1 && nums2Index <= nums2.length-1){
                if( nums1[nums1Index] <= nums2[nums2Index] ){
                    resultList.add(nums1[nums1Index++]);
                }else {
                    resultList.add(nums2[nums2Index++]);
                }
            }else if( nums1Index > nums1.length-1 && nums2Index <= nums2.length-1 ){
                resultList.add(nums2[nums2Index++]);
            }else if( nums1Index <= nums1.length-1 && nums2Index > nums2.length-1 ){
                resultList.add(nums1[nums1Index++]);
            }else {
                break;
            }
        }


        return 0;

    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;

    }
}
