package com.example.interview.view0304;


import java.util.Stack;

public class MyQueue {

    Stack<Integer> inStatck;
    Stack<Integer> outStatck;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStatck = new Stack<>();
        outStatck = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStatck.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStatck.empty()){
            in2out();
        }
        return outStatck.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStatck.empty()){
            in2out();
        }
        return outStatck.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStatck.isEmpty() && outStatck.empty();
    }

    public void in2out(){
        while (!inStatck.empty()){
            outStatck.push(inStatck.pop());
        }
    }
}
