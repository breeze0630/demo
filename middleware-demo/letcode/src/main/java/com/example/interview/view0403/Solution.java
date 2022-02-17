package com.example.interview.view0403;

import java.util.Arrays;

public class Solution {

    ListNode[] listNodes = null;
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return listNodes;
        }
        listNodes = new ListNode[1];
        inner(1,tree);
        return listNodes;
    }

    public void inner( int n , TreeNode tree){
        if( n > 1){
            if(listNodes.length < n){
                ListNode[] listNodesTmp = Arrays.copyOf(listNodes,listNodes.length+1,ListNode[].class);
                listNodesTmp[n-1] = new ListNode(tree.val);
                listNodes = listNodesTmp;
            }else {
                addNode(listNodes[n-1],new ListNode(tree.val));
            }

        }else {
            listNodes[0] = new ListNode( tree.val);
        }
        if(tree.left != null){
            inner(n+1,tree.left);
        }
        if(tree.right != null){
            inner(n+1,tree.right);
        }
    }

    void addNode(ListNode listNode,ListNode newNode){
        if(listNode.next != null){
            addNode(listNode.next,newNode);
        }else {
            listNode.next = newNode;
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}