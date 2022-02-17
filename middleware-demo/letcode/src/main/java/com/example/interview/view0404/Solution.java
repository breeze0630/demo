package com.example.interview.view0404;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null ){
            return true;
        }
        int l = pathLength(root.left,2);
        int r = pathLength(root.right,2);
        return Math.abs(l - r) > 1 ? false : ( isBalanced(root.left) ? isBalanced(root.right) : false) ;
    }


    int pathLength(TreeNode root , int n){
        if(root == null){
            return n - 1;
        }
        if(root.left == null && root.right == null)
        {
            return n;
        }
        int l = pathLength(root.left,n+1);
        int r = pathLength(root.right,n+1);
        return Math.max(l,r);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}