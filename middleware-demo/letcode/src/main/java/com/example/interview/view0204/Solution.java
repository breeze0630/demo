package com.example.interview.view0204;

public class Solution {

    public static void main(String[] args) {

        ListNode res = new Solution().partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),3);
//        ListNode res1 = new Solution().partition(new ListNode(2,new ListNode(1)),2);

    }

    public ListNode partition(ListNode head, int x) {

        ListNode pre = new ListNode(-1000);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre.next;
        ListNode fastpre = pre;
        while (fast != null) {
            if (fast.val < x) {
                if(fast != slow) {
                    //需要移动
                    ListNode tmp = slow.next;
                    fastpre.next = fast.next;
                    fast.next = tmp;
                    slow.next = fast;
                    fast = fastpre.next;

                }else {
                    fast = fast.next;
                    slow = slow.next;
                    fastpre =fast;
                }
                if (slow.next != null && slow.next.val < x) {
                    slow = slow.next;
                }
            } else {
                fastpre = fast;
                fast = fast.next;
            }
        }
        return pre.next;
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
