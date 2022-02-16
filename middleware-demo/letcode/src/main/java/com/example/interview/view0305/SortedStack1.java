package com.example.interview.view0305;

import java.util.Stack;

public class SortedStack1 {
    Stack<Integer> stack;
    Stack<Integer> tmp ;

    public SortedStack1() {
        stack = new Stack<>();
        tmp = new Stack<>();

    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.add(val);
            return;
        }
        stack.add(val);
        sort();
    }

    private void sort(){

        int c = stack.pop();
        while (!stack.isEmpty()){
            int t = stack.pop();
            if(t >= c){
                stack.add(t);
                break;
            }
            tmp.add(t);
        }
        stack.add(c);
        while (!tmp.isEmpty()){
            stack.add(tmp.pop());
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
