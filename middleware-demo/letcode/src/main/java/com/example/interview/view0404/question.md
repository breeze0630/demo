### 面试题 04.04. 检查平衡性

```text
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

```

##### 示例 1:
```text
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
```

##### 示例 2:
```text
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。

```


```text
题解：递归遍历每个节点，当前节点符合平衡树，继续遍历子节点，期间遇到 不平衡树则结束

 public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
这是官方题解中计算子节点高度的函数，代码较为简洁
```