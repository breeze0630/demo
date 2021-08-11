package com.example.letcode.hot2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
            int[] l1 = {2,4,3};
            int[] l2 = {5,6,4};

    }

    /**
     * 官方方法
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

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return this.addTwoNumbers3(l1, l2, 0);
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2, int a) {
        if (l1 == null && l2 == null) {
            return a == 0 ? null : new ListNode(a);
        }
        if (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            a += l2.val;
            l2 = l2.next;
        }
        return new ListNode(a % 10, addTwoNumbers3(l1, l2, a / 10));
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
