package com.example.interview.view0409;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = null;
    List< List<Integer>> map = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {

        res = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int i = 1;
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new ArrayList<>();
            for (TreeNode node : nodes) {
                if(map.size() < i ){
                    map.get(i).add(root.val);
                }else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(root.val);
                    map.add( tmp);
                }
                if (node.left != null) {
                    newNodes.add(node.left);
                }
                if (node.right != null) {
                    newNodes.add(node.right);
                }
            }
            i++;
            nodes.clear();
            nodes.addAll(newNodes);
        }

        for( List<Integer> innerList : map ){

            List<Integer> tmp = new ArrayList<>();

   /*         if(res.size() == 0){
                tmp.add(innerList.get(0));
                res.add(tmp);
            } */
            for( int j = 0 ; j < innerList.size() ; j++)
            {
                tmp.add(innerList.get(j));
            }
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