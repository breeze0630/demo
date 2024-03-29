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
        ListNode fast = pre;
        ListNode fastpre = pre;
        while (fast != null) {
            if (fast.val < x) {
                if(fast != slow ) {
                    //需要移动
                    ListNode tmp = slow.next;
                    fastpre.next = fast.next;
                    fast.next = tmp;
                    slow.next = fast;
                    fast = fastpre.next;

                }else {
                    fastpre = fast;
                    fast = fast.next;
                }
                if (slow!=null&&slow.next != null && slow.next.val < x) {
                    slow = slow.next;
                }
            } else {
                fastpre = fast;
                fast = fast.next;
            }
        }
        return pre.next;
    }


    public ListNode partition1(ListNode head, int x) {

        ListNode pre = new ListNode(-1000);
        pre.next = head;
        ListNode cur = pre.next;
        ListNode parent = pre;
        while (cur != null){
            if(cur.val < x && parent != pre){
                parent.next = cur.next;
                cur.next = null;
                ListNode tmp = pre.next ;
                cur.next = tmp;
                pre.next = cur;
                cur = parent.next;
            }else {
                parent = cur;
                cur = cur.next;
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
