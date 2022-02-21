package com.example.interview.view0108;

public class Solution {

    public void setZeroes(int[][] matrix) {

        if(matrix == null || matrix.length < 1){
            return;
        }
        int i = 0;
        boolean[][] bos = new boolean[matrix.length][matrix[0].length];
        while ( i < matrix.length){
            int j = 0 ;
            while ( j < matrix[i].length){
                if( matrix[i][j] == 0){
                    bos[i][j] = true;
                }
                j++;
            }
            i++;
        }
        i = 0;
        while ( i < bos.length){
            int j = 0 ;
            while ( j < bos[i].length){
                if( bos[i][j]){
                    int index = 0;
                    while ( index < matrix[i].length){
                        matrix[i][index] = 0;
                        index++;
                    }
                    index = 0;
                    while ( index < matrix.length){
                        matrix[index][j] = 0;
                        index++;
                    }
                }
                j++;
            }
            i++;
        }
    }

}
