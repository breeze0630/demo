package com.example.interview.view0202;

public class Solution {

    private ListNode t = null;
    public int kthToLast(ListNode head, int k) {

        getNode(head,k);

        return t != null ? t.val : -1;
    }

    public int getNode(ListNode node,int target){
        if(node == null)
        {
            return 0;
        }
        int current = getNode(node.next,target) + 1;

        if(t != null){
            return current;
        }
        if(current == target){
             t = node;
        }
        return current;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
