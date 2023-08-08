package com.example.interview.view0208;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode detectCycle2(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){



        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode c = head;
        while (c != null){
            if(!set.add(c)){
                return c;
            }
        }
        return null;
    }
    
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }
}

