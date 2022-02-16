package com.example.interview.view0301;


import java.util.Arrays;

public class TripleInOne {


    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(2);
        tripleInOne.push(0,1);
        tripleInOne.push(0,2);
        tripleInOne.push(0,3);
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.peek(0));
    }

    int[][] arr ;
    int stackSize ;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[3][0];
    }

    public void push(int stackNum, int value) {
        if(stackNum >= arr.length){
            return;
        }
        if(stackSize == 0)
        {
            return;
        }
        if(arr[stackNum] != null && arr[stackNum].length > 0){
            if(arr[stackNum].length >= stackSize){
                return;
            }
            int[] newArr = Arrays.copyOf(arr[stackNum],arr[stackNum].length+1);
            newArr[newArr.length-1] = value;
            arr[stackNum] = newArr;
        }else if(arr[stackNum] == null || arr[stackNum].length == 0){
            arr[stackNum] = new int[1];
            arr[stackNum][0] = value;
        }
    }

    public int pop(int stackNum) {
        int[] tmp = arr[stackNum];
        if(tmp == null || tmp.length == 0){
            return -1;
        }
        int res = tmp[tmp.length-1];
        if(tmp.length > 1){
            int[] newArr = Arrays.copyOfRange(tmp,0,tmp.length-1);
            arr[stackNum] = newArr;
        }else {
            arr[stackNum] = null;
        }

        return res;
    }

    public int peek(int stackNum) {
        int[] tmp = arr[stackNum];
        if(tmp == null || tmp.length == 0){
            return -1;
        }
        return tmp[tmp.length-1];
    }

    public boolean isEmpty(int stackNum) {
        return arr[stackNum] == null || arr[stackNum].length == 0;
    }
}
