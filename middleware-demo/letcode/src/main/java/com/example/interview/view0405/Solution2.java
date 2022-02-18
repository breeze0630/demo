package com.example.interview.view0405;

public class Solution2 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(new Solution().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }



    public boolean check(TreeNode root , Integer lower,Integer upper){
        if (root == null ) {
            return true;
        }

        int val = root.val;
        if(lower != null && val <= lower){
            return false;
        }
        if(upper != null && val >= upper){
            return false;
        }
        if( !check(root.left,lower,val)){
            return false;
        }

        if( ! check(root.right,val,upper)){
            return false;
        }
        return true;
    }
}

