package com.example.interview.view0207;

public class Solution {

    public static void main(String[] args) {
        ListNode gong = new ListNode(4,new ListNode(5));
        ListNode res = new Solution().getIntersectionNode(new ListNode(1,gong),new ListNode(2,new ListNode(3,gong)));
        System.out.println(res);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode firstB = headB;
        ListNode firstA = headA;

        while (headA != null) {

            ListNode tmpB = firstB;
            while (tmpB != null) {
                if (tmpB == headA) {
                    return headA;
                }
                tmpB = tmpB.next;
            }

        }

        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }
}
