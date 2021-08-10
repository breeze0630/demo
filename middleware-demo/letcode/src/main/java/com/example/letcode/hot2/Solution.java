package com.example.letcode.hot2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 先转成数组
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = null;
        ListNode node = first;

        boolean flag = true;
        int sum = 0;
        int index = 0;
        List<Integer> l1List = new ArrayList<>();
        while ( l1.next != null){
            l1List.add(l1.val);
        }
        List<Integer> l2List = new ArrayList<>();
        while ( l2.next != null){
            l2List.add(l2.val);
        }
        List<Integer> l3List = new ArrayList<>();

        for ( int i = 0 ; i < l1List.size() || i < l2List.size() ; i++ ){
            int l1Data = i < l1List.size() ? l1List.get(i) : 0 ;
            int l2Data = i < l1List.size() ? l1List.get(i) : 0 ;
            int inner = l1Data+l2Data+sum ;
            if(inner > 10){
                sum = inner - 10;
            }else if(inner == 10){
                sum = 1;
            }
            l3List.add()
        }
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
