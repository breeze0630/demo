
### 面试题 04.02. 最小高度树

#### 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

##### 示例:

```text

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0 
         / \ 
       -3   9 
       /   / 
     -10  5 

```

```text

题解：
递归二分数组，这样能达到二叉树高度最低
Solution 第一个版本，通过传入根节点，赋值根节点的子节点
Solution1 参考其他人的递归，优化后代码
```