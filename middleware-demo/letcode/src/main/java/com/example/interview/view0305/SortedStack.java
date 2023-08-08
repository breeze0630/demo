package com.example.interview.view0305;

import java.util.Deque;
import java.util.LinkedList;

public class SortedStack {

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        //["SortedStack", "push", "push", "peek", "pop", "peek"]
        //[[], [1], [2], [], [], []]

        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    Deque<Integer> stack;
    Deque<Integer> tmp ;

    public SortedStack() {
        stack = new LinkedList<Integer>();
        tmp = new LinkedList<>();
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

        int c = stack.pollLast();
        while (!stack.isEmpty()){
            int t = stack.pollLast();
            if(t >= c){
                stack.add(t);
                break;
            }
            tmp.add(t);
        }
        stack.add(c);
        while (!tmp.isEmpty()){
            stack.add(tmp.pollLast());
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pollLast();
    }

    public int peek() {
       return stack.isEmpty() ? -1 : stack.peekLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
