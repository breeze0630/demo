### 面试题 04.05. 合法二叉搜索树

```text

实现一个函数，检查一棵二叉树是否为二叉搜索树。

```

##### 示例 1:

```text
输入:
    2
   / \
  1   3
输出: true
```

##### 示例 2:
```text
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

```

```text
题解：
Solution ，直接通过递归逐层遍历，每次需要查出子树的极值与当前根节点对比
Solution1 ，参照官方答案，递归中传入下一级子树所需要遵守的极值，子树不符合则整棵树不符合
```