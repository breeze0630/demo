package com.example.interview.view0412;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root,22));

    }

    int count;
    public int pathSum(TreeNode root, int sum) {
        path(root,sum);
        return count;
    }

    public void path(TreeNode root,int sum){
        if(root == null){
            return;
        }
        process(root,sum,0);
        path(root.left,sum);
        path(root.right,sum);
    }

    void process( TreeNode node, int sum , int pathSum){
        if(node == null){
            return ;
        }

        if(node.val + pathSum == sum){
            this.count++;
            return;
        }
        if(node.left != null){
            process(node.left,sum,node.val+pathSum);
        }
        if(node.right != null){
            process(node.right,sum,node.val+pathSum);
        }
    }
    
    
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}