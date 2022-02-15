package com.example.interview.view0304;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue1 {

    Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyQueue1() {
        deque = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return deque.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        return deque.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
