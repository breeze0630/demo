package com.example.interview.view0406;

public class Solution {

    public static void main(String[] args) {



        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        TreeNode res = new Solution().inorderSuccessor(root,new TreeNode(5));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return hasNext(null,root,p);
    }
    public TreeNode hasNext(TreeNode pre,TreeNode root,TreeNode target){
        if(root == null){
            return null;
        }

        if(root.val == target.val){
            if(root.right != null){
               return  child(root.right);
            }
            return pre != null ? pre : null;
        }

        if(root.val < target.val){
            TreeNode r =  hasNext(pre,root.right,target) ;
            return r;
        }else {
            TreeNode l =  hasNext(root,root.left,target);
            return l;
        }
    }

    public TreeNode child(TreeNode root){
        if(root.left != null){
            return child(root.left);
        }else if(root.right != null){
            return child(root.right);
        }
        return root;
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