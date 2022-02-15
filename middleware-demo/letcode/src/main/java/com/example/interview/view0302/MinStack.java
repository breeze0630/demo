package com.example.interview.view0302;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 执行push、pop和min操作的时间复杂度必须为O(1)
 */
public class MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println("top:"+minStack.top());
        System.out.println(minStack.getMin());

    }
    Deque<Integer> all;
    Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        all = new LinkedList<>();
        min = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        all.push(x);
        min.push(Math.min(min.peek(),x));
    }

    public void pop() {
        all.pop();
        min.pop();
    }

    public int top() {
        int tmp = all.peek();
        return tmp;
    }

    public int getMin() {
        int tmp = min.peek();
        return tmp;
    }
}
