package com.example.interview.view0402;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println((1+0)/2);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length<1){
            return null;
        }
      return child(nums,0,nums.length-1);
    }

    public TreeNode child( int[]  nums, int start,int end){
        if(end-start >= 0) {
            int mid = (end + start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = child(nums,start,mid-1);
            root.right = child(nums,mid+1,end);
            return root;
        }

        return null;
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
