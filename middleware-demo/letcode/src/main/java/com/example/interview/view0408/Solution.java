package com.example.interview.view0408;


public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode res = new Solution().lowestCommonAncestor(root,root.left,root.right);
        System.out.println(res);
    }
    private TreeNode res = null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        has(root,p,q);
        return this.res;
    }
    public boolean has( TreeNode root , TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }
        boolean lhas = has(root.left,p,q);
        boolean rhas = has(root.right,p,q);
        if( ( lhas && rhas ) || (( root.val == p.val || root.val == q.val)  && ( lhas || rhas ) )){
            this.res = root;
        }
        return  lhas || rhas || (root.val == p.val ||  root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        getList(root,left,p);
        getList(root,right,q);

        if(left.next == null || right.next == null){
            return null;
        }

        ListNode l2 = new ListNode(-1);
        ListNode r2 = new ListNode(-1);

        left = left.next;
        while (left != null){
            ListNode tmp = l2.next;
            l2.next = new ListNode(left.val);
            l2.next.next = tmp;
            left = left.next;
        }

        right = right.next;
        while (right != null){
            ListNode tmp = r2.next;
            r2.next = new ListNode(right.val);
            r2.next.next = tmp;
            right = right.next;
        }

        ListNode node = getIntersectionNode(l2.next,r2.next);
        return node != null ? new TreeNode(node.val) : null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while ( true ) {
            if( A == null && B == null){
                break;
            }
            if( A != null && B != null && A.val == B.val){
                break;
            }
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }



    boolean getList(TreeNode root , ListNode list,TreeNode target){
        if(root == null){
            return false;
        }
        if(root.val == target.val){
            ListNode tmp = list.next;
            list.next = new ListNode(root.val);
            list.next.next = tmp;
            return true;
        }

        if(getList(root.left,list,target)){
            ListNode tmp = list.next;
            list.next = new ListNode(root.val);
            list.next.next = tmp;
            return true;
        }
        if(getList(root.right,list,target)){
            ListNode tmp = list.next;
            list.next = new ListNode(root.val);
            list.next.next = tmp;
            return true;
        }
        return false;
    }
    
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x, ListNode n) {
        val = x;
        this.next = n;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
