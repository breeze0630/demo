package com.example.interview.view0201;

import java.util.*;

public class Solution
{

    public static void main(String[] args) {

        ListNode res = new Solution().removeDuplicateNodes(
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(2,new ListNode(1,null))))))
        );
        System.out.println();
    }

/*

public ListNode removeDuplicateNodes(ListNode head) {
           if(head == null || head.next == null){
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        Set<Integer> list = new HashSet<>();
        ListNode current = head;
        list.add(head.val);
        while (current != null){
            if(current.next == null){
                break;
            }
            if(list.contains(current.next.val)){
                current.next = current.next.next;
            }else {
                list.add(current.next.val);
                current = current.next;
            }
        }
        return first.next;
    }

*
* */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        Set<Integer> list = new HashSet<>();
        ListNode current = head;
        list.add(head.val);
        while (current.next != null){
            if(list.add(current.next.val)){
                current = current.next;
            }else {
                current.next = current.next.next;
            }
        }
        return first.next;
    }




}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode node) { val = x;next = node; }
}