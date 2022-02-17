package com.example.interview.view0405;

public class Solution {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(new Solution().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {

        if(root == null || (root.left == null && root.right == null) ){
            return true;
        }

        boolean l = (root.left == null) || (root.left != null && root.val > root.left.val );
        boolean r = (root.right == null) || (root.right != null && root.val < root.right.val);
        return l && r ? ( isValidBST( root.left) && (root.left == null || root.val > max(root.left)) && isValidBST(root.right) && ( root.left == null || root.val < min(root.right))) : false;
    }

    public int min(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val;
        }
        int l = root.left != null ? min(root.left) : root.val;
        int r = root.right != null ? min(root.right) : root.val;
        return Math.min(l,r);
    }

    public int max(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val;
        }
        int l = root.left != null ? max(root.left) : root.val;
        int r = root.right != null ? max(root.right) : root.val;
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
