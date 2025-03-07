package com.example.huawei.day0001;

import java.util.Scanner;

/**
 *
 * 滑动窗口最大值
 * 有一个N个整数的 数组只，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止,每次窗口滑动产生一个窗口和(窗口内所有数的和)，求窗口滑动产生的所有窗口和的最大值
 *
 * @auther: liubiao
 * @date: 2025-03-07
 */
public class Day0001 {

    public static void main(String[] args) {
        //输入数组长度
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度:");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        System.out.println("请依次输入数组:");
        for(int i = 0; i< array.length ; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("请输入窗口大小:");
        int window = scanner.nextInt();

        System.out.println("数组的最大窗口和为:"+process(array,window));

    }

    public static int process(int[] array , int window){

        if(array == null || array.length <= 0){
            return  -1;
        }

        int max = Integer.MIN_VALUE ;

        if(window >= array.length){
            for(int i = 0 ; i < array.length ; i++){
                max+=array[i];
            }
        }else {
            int last = Integer.MIN_VALUE;
            for(int i = 0; i <= array.length - window; i++ ){
                //变量从  i 到 i+ window -1 这些节点的数据
                int lengthTemp = i + window ; // 临时右指针
                if( i == 0){
                    int tempSum = 0;
                    for( int j = i; j < lengthTemp ; j++ ){
                        tempSum += array[j];
                    }
                    last = tempSum;
                    max = Math.max(tempSum,max);
                }else {
                    last = last - array[i-1] + array[lengthTemp-1];
                    max = Math.max(last,max);
                }
            }
        }

        return max;

    }
}
