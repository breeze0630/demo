package com.example.letcode.hot2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
            int[] l1 = {2,4,3};
            int[] l2 = {5,6,4};

    }

    /**
     * 先转成数组
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode node = null;

        boolean flag = true;
        int carry = 0;
        int index = 0;
        while ( flag ){
            int sum =  ( l1 != null ? l1.val : 0 ) + (l2 != null ? l2.val : 0 ) + carry;
            carry = sum / 10 ;
            ListNode newNode = new ListNode(sum % 10);
            if(index == 0){
                first = node = newNode;
            }else {
                node.next = newNode;
                node = node.next;
            }
            if(l1.next != null){
                l1 = l1.next;
            }
            if(l2.next != null){
                l2 = l2.next;
            }
            if(l1 == null && l2 == null){
                flag = false;
            }
            index++;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            node.next = newNode;
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
