package com.example.hot.hot48;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/25
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

    //解题
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int mid = (matrix.length + 1) / 2;
        for (int l = 0; l < mid; l++) {
            for(int r = 0; r < mid;r++){
                int l1 = matrix[l][r];
                int l2 = matrix[l][n-r];
                int r1 = matrix[n-l][r];
                int r2 = matrix[n-l][n-r];
                matrix[l][r] = r1;
                matrix[n-l][r]= r2;
                matrix[n-l][n-r] = l2;
                matrix[l][n-r] = l1;
            }
        }
    }
}
