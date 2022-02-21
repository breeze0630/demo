package com.example.interview.view0203;

public class Solution {


    public static void main(String[] args) {
        ListNode root = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        new Solution().deleteNode(root);
        System.out.println("1");
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x,ListNode n) {
        val = x;
        this.next = n;
    }

}

