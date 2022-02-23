package com.example.interview.view0205;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int tmp = 0;
        ListNode listNode = new ListNode(Integer.MIN_VALUE);
        ListNode pre = listNode;

        while (l1 != null || l2 != null ){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum =   a + b + tmp;
            listNode.next = new ListNode(sum % 10);
            tmp = sum / 10;
            listNode = listNode.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if(tmp != 0){
            listNode.next = new ListNode(1);
        }

        return pre.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x, ListNode n) {
        val = x;
        this.next = n;
    }
}
