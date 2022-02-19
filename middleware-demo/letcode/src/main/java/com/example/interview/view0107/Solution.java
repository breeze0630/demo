package com.example.interview.view0107;

public class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length-1;
        int i = 0;
        while ( i <= n/2){
            int j = 0;
            while (j <= n/2){
                if(n%2==1){
                    j++;
                    continue;
                }
                int a1 = matrix[i][j];
                int a2 = matrix[j][n-i];
                int a3 = matrix[n-i][n-j];
                int a4 = matrix[n-j][i];
                matrix[j][n-i] = a1;
                matrix[n-i][n-j] = a2;
                matrix[n-j][i] = a3;
                matrix[i][j] = a4;
                j++;
            }
            i++;
        }

    }


}
