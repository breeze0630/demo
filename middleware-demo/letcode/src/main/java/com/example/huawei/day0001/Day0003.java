package com.example.huawei.day0001;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 路灯照明问题
 *
 * 在一条笔直的公路上安装了N个路灯，从位置0开始安装，路灯之间间距固定为100米。每个路灯都有自己的照明半径，请计算第一个路灯
 * 和最后一个路灯之间，无法照明的区间的长度和。
 * @auther: liubiao
 * @date: 2025-03-07
 */
public class Day0003 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入路灯数:");
        int lightLength = scanner.nextInt();
        System.out.println("输入照明半径:{}");
        int[] array = new int[lightLength];

        for(int i = 0 ; i< lightLength ; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("无法照明的区间长度和:" +new Day0003(). process2(lightLength,array));
    }
    public  int process2(int lightLength,int[] array){

        if(lightLength == 1){
            return 0;
        }
        int dark = 0 ;
        // 计算得到 每个灯的照明区间

        List<Light> lightList = new LinkedList<>();
        for(int i = 0; i< lightLength ; i++){
            int left  = Math.max( 100 * i - array[i],0);
//            int right = Math.max( 100 * i + array[i],last);
            int right =  100 * i + array[i];
            lightList.add(new Light(left,right));
        }

        lightList.sort(Comparator.comparing(a->a.left));
        Light current = lightList.get(0);
        List<Light> merges = new LinkedList<>();
        for(int i = 1 ; i < lightList.size();i++){
            Light next = lightList.get(i);
            //判断两个是否重叠，排序过，重叠时，只需要处理 右边，左边一定不小于后面的灯
            if(next.left< current.right){
                //重叠
                current.right = Math.max( next.right,current.right);
            }else {
                //不重叠，将next 替换为current
                merges.add(current);
                current = next;
            }
        }

        merges.add(current);
        //计算不重合部分
        for(int i = 1 ; i < merges.size();i++){
            dark += calcDark(merges.get(i-1),merges.get(i));
        }

        return dark;
    }
    public  int process(int lightLength,int[] array){

        if(lightLength == 1){
            return 0;
        }
        int sum = 0 ;
       // 计算得到 每个灯的照明区间

        List<Light> lightList = new LinkedList<>();
        int last = (lightLength-1) * 100;
        for(int i = 0; i< lightLength ; i++){
            int left  = Math.max( 100 * i - array[i],0);
//            int right = Math.max( 100 * i + array[i],last);
            int right =  100 * i + array[i];

            lightList.add(new Light(left,right));
        }

        lightList.sort(Comparator.comparing(a->a.left));

        List<Light> merges = new LinkedList<>();

        Light  current = lightList.get(0);
        for(int i = 1 ;i < lightList.size() ; i++){
            //前一个灯 和 当前灯的间隔看是否重合
            Light next = lightList.get(i);

            if(current.right >= next.left){
                //重叠
                current.right = Math.max(current.right,next.right);
            }else{
                merges.add(current);
                current = next;
            }
        }

        merges.add(current);
        int dark = 0;

        for(int i = 1; i < merges.size();i++){
            dark += calcDark(merges.get(i-1),merges.get(i));
        }

        dark += Math.max(0,merges.get(0).left);
        return dark;
    }

    public class Light{
        public int left;
        public int right;

        public Light(int left,int right){
            this.left = left;
            this.right = right;
        }
    }

    public int calcDark(Light pre,Light next){
        return Math.max(0,next.left - pre.right);

    }
}
