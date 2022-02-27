package com.example.interview.view0410;

public class Solution {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return check(t1,t2);
    }

    public boolean check(TreeNode t1 ,TreeNode t2){
        if(t1 == null){
            return false;
        }
        if(t1.val == t2.val){
            boolean isSubRes = isSub(t1,t2);
            return isSubRes;
        }

        boolean isLeft = check(t1.left , t2);
        if(isLeft){
            return isLeft;
        }else {
            return check(t1.right,t2);
        }
    }

    public boolean isSub(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }else if( t1 != null && t2 != null) {
            if (t1.val == t2.val) {
                if (isSub(t1.left, t2.left) && isSub(t1.right, t2.right)) {
                    return true;
                }
            }
        }
        return false;
    }

    
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }