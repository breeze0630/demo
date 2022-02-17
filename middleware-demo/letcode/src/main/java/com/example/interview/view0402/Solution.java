package com.example.interview.view0402;

public class Solution {

    public static void main(String[] args) {
        System.out.println((1+0)/2);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length<1){
            return null;
        }
     int mid = nums.length / 2;
     TreeNode root = new TreeNode(nums[mid]);

     hasChild(root,nums,0,mid-1,mid+1,nums.length-1);
      return root;
    }

    public void hasChild( TreeNode root,int[]  nums, int lstart,int lend,int rstart,int rend){
        if(lend-lstart >= 1) {
            int lmid = (lstart + lend) / 2;
            TreeNode leftChild = new TreeNode(nums[lmid]);
            root.left = leftChild;
            hasChild(leftChild,nums,lstart,lmid-1,lmid+1,lend);
        }else if(lend - lstart == 0){
            TreeNode leftChild = new TreeNode(nums[lend]);
            root.left = leftChild;
        }
        if(rend-rstart >= 1) {
            int rmid = (rstart + rend) / 2;
            TreeNode rightChild = new TreeNode(nums[rmid]);
            root.right = rightChild;
            hasChild(rightChild,nums,rstart,rmid-1,rmid+1,rend);
        }else if(rend - rstart == 0){
            TreeNode rightChild = new TreeNode(nums[rend]);
            root.right = rightChild;
        }
    }

}

