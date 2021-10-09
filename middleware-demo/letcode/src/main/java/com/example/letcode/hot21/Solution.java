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
        ListNode end = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while ( l1 != null && l2 != null){
            if(first == null){
                if(l1.val <= l2.val ){
                    first = new ListNode(l1.val,null);
                    l1 = l1.next;
                    end = first;
                }else {
                    first = new ListNode(l2.val,null);
                    l2 = l2.next;
                    end = first;
                }
                continue;
            }
            if(l1.val <= l2.val ){
                end.next = new ListNode(l1.val,null);
                l1 = l1.next;
            }else {
                end.next = new ListNode(l2.val,null);
                l2 = l2.next;
            }
            end = end.next;

        }

        if(l1 != null){
            end.next = l1;
        }
        if(l2 != null){
            end.next = l2;
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