package com.example.interview.view0206;



public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isPalindrome(
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(2,new ListNode(1,null))))))
        ));
        System.out.println(new Solution().isPalindrome(
                new ListNode(1,new ListNode(2)))
        );
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null ){
            return true;
        }
        if( head.next == null ){
            return false;
        }

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode first2 = new ListNode(-1);
        ListNode c2 = first2;
        while (head != null){
            ListNode lin = new ListNode(head.val);
            lin.next = first2.next;
            first2.next = lin;
            head = head.next;
        }
        ListNode head2 = first.next;
        ListNode c3 = first2.next;
        while (head2 != null && c3 != null){
            if(head2.val != c3.val){
                return false;
            }
            head2 = head2.next;
            c3 = c3.next;
        }

        return true;
       /* ListNode c = head.next;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(head.val);
        while (c != null){
            int tmp = list.peekLast();
            if(c.val != tmp){
                list.add(c.val);
            }else {
                list.removeLast();
            }
            c = c.next;
        }
        return list.size() == 0;*/
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode node) { val = x;next = node; }
}
