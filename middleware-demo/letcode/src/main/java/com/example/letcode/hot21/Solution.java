package com.example.letcode.hot21;

public class Solution {

    public static void main(String[] args) {

        ListNode first = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode end = new ListNode(1,new ListNode(3,new ListNode(4,null)));

        ListNode result = new Solution().mergeTwoLists(first,end);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode first = null;
        ListNode result = null;
        while ( l1.next != null && l2.next != null){
            if(first == null){
                if(l1.val <= l2.val ){
                    first = new ListNode(l1.val,null);
                    l1 = l1.next;
                    result = first;
                }else {
                    first = new ListNode(l2.val,null);
                    l2 = l2.next;
                    result = first;
                }
                continue;
            }
            if(l1.val <= l2.val ){
                result.next = new ListNode(l1.val,null);
                l1 = l1.next;
            }else {
                result.next = new ListNode(l2.val,null);
                l2 = l2.next;
            }

        }

        if(l1.next != null){
            result.next = l1;
        }
        if(l2.next != null){
            result.next = l2;
        }
        return first;
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}