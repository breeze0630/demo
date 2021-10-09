package com.example.letcode.hot23;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if( lists.length == 0){
            return null;
        }
        if( lists.length == 1){
            return lists[0];
        }

        int length = 1;
        ListNode left = lists[0];
        while (length < lists.length ){
            left = mergeTwoLists(left,lists[length]);
            length++;
        }
        return left;
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
