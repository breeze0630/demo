package com.example.interview.view0303;

import java.util.Arrays;
import java.util.Stack;

public class StackOfPlates {

    /**
     *  输入：
     * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
     * [[1], [1], [2], [1], [], []]
     *  输出：
     * [null, null, null, 2, 1, -1]
     *
     */

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(2);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);

        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));

    }

    Stack<Integer>[] stacks  ;

    int cap ;
    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {

        if(stacks == null){
            if(cap > 0) {
                stacks = new Stack[1];
                stacks[0] = new Stack<>();
                stacks[0].push(val);
            }
        }else {
            if( stacks[stacks.length-1].size() >= cap){
                Stack<Integer>[] newArr = Arrays.copyOf(stacks,stacks.length+1,Stack[].class);
                newArr[stacks.length] = new Stack<>();
                newArr[stacks.length].push(val);
                stacks = newArr;
            }else {
                stacks[stacks.length-1].push(val);
            }
        }

    }

    public int pop() {
        int tmp = -1;
        if(stacks!=null){
            tmp = stacks[stacks.length-1].pop();

            if(stacks[stacks.length-1].isEmpty()){
                if(stacks.length>1) {
                    Stack<Integer>[] newArr = Arrays.copyOf(stacks, stacks.length - 1, Stack[].class);
                    stacks = newArr;
                }else {
                    stacks = null;
                }
            }
        }
        return tmp;
    }

    /**
     *
     * @param index 子栈下标 从 0 开始
     * @return
     */
    public int popAt(int index) {
        int tmp = -1;
        if(stacks!=null && index < stacks.length){
            tmp = stacks[index].pop();
            if(stacks[index].isEmpty()){
                if(stacks.length > 1) {

                    Stack<Integer>[] newArr = new Stack[stacks.length-1];
                    int newi = 0;
                    for (int i = 0 ; i < stacks.length;i++ )
                    {
                        if(i!=index){
                            newArr[newi] = stacks[i];
                            newi++;
                        }
                    }
                    stacks = newArr;
                }else {
                    stacks = null;
                }
            }
        }
        return tmp;
    }
}
