package com.example.hot.hot25;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        ListNode node = new Solution().getListNode(3);
        System.out.println("1");
    }

    /**
     * k
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k < 2){
            return head;
        }

        ListNode hair = new ListNode(-1,head);
        ListNode pre = hair;
        while (head != null){
            //外层的循环的起始节点都是 pre.next ,在开启下次外层循环时，需要将 pre 重置为上一轮处理的尾结点
            ListNode tail = pre;
            for( int i = 0 ; i < k;i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            //得到深度为K的链表,链表的最后
            ListNode nex = tail.next;
            ListNode[] reverse = innerReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //将翻转后的子链表接回去
            pre.next = head;
            tail.next = nex;

            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    /**
     * 逐个将头节点调换到链表后面，直到头尾相同结束
     * 交换，返回头、尾节点数组
     * @param head
     * @param tail
     * @return
     */
    public ListNode[] innerReverse(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail){
            ListNode nex = p.next;
            p.next = prev ;
            prev  = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }

    public ListNode getListNode(int len){
        if(len == 0){
            return null;
        }
        int i = 0;
        ListNode head = new ListNode(-1,null);
        ListNode current = head;
        while ( i < len){
            i++;
            ListNode newNode = new ListNode(new Random().nextInt(10),null);
            current.next = newNode;
            current = current.next;
        }
        return head.next;
    }

}




   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
