package com.example.letcode.hot4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0 , nums2Index = 0;
        List<Integer> resultList = new ArrayList<>();
        while (true){
                if(nums1Index <= nums1.length && nums2Index <= nums2.length){
                    if( nums1[nums1Index] <= nums2[nums2Index] ){
                        resultList.add(nums1[nums1Index++]);
                    }else {
                        resultList.add(nums2[nums2Index++]);
                    }
                }else if( nums1Index > nums1.length && nums2Index <= nums2.length ){
                    resultList.add(nums2[nums2Index++]);
                }else if( nums1Index <= nums1.length && nums2Index > nums2.length ){
                    resultList.add(nums1[nums1Index++]);
                }else {
                    break;
                }
        }
        return (resultList.size() % 2 == 0) ?
                ( (double)resultList.get(resultList.size() / 2 ) + (double) resultList.get(resultList.size() / 2 + 1) ) / 2
                : Double.valueOf(resultList.get(resultList.size() / 2 + 1 ));

    }
}
