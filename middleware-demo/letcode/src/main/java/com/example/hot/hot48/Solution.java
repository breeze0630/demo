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
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        Solution s = new Solution();
        s.rotate(matrix);
        s.rotate(matrix2);

        System.out.println(3/2);
        System.out.println(JSON.toJSONString(matrix));
        System.out.println(JSON.toJSONString(matrix2));

    }

    //解题
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int l = 0; l < n/2 ; l++) {
            for (int r = 0; r < ( n + 1 )/ 2; r++) {
                int l1 = matrix[l][r];
                int l2 = matrix[r][n - l];
                int l3 = matrix[n - l][n - r];
                int l4 = matrix[n - r][l];
                matrix[l][r] = l4;
                matrix[r][n - l] = l1;
                matrix[n - l][n - r] = l2;
                matrix[n - r][l] = l3;
            }
        }
    }
}
