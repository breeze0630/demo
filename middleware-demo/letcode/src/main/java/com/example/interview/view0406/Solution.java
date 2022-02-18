package com.example.interview.view0406;

public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode res = new Solution().inorderSuccessor(root,new TreeNode(1));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return hasNext(null,root,p);
    }
    public TreeNode hasNext(TreeNode pre,TreeNode root,TreeNode target){
        if(root == null){
            return null;
        }

        if(root.val == target.val){
            return pre != null ? pre : null;
        }

        if(root.val < target.val){
            TreeNode r =  hasNext(pre,root.right,target) ;
            return r;
        }{
            TreeNode l =  hasNext(root,root.left,target);
            return l;
        }
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