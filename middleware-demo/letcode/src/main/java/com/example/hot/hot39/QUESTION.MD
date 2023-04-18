## 39. 组合总和

#### 题干
```text
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。
```

`示例 1：`

```text
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。7 也是一个候选， 7 = 7 。仅有这两种组合。
```

`示例 2：`

```text
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
```

`示例 3：`

```text
输入: candidates = [2], target = 1
输出: []
```

`解题思路`
```text
1、求可能的解一般都能用搜索回溯法（具体为递归）
从第一个数开始，每个数都可以选择和不选择
设置 candidates 的 当前下标 为 ids
因此结束条件 为 target == 0 或者 candidates 已经读取完
结束判断
a、 ids == candidates.length : 直接返回
b、 target == 0 : 已计算出目标数组，将 nums[] 复制一份添加到 二维数组
设置已经添加的数组 为  nums[],
a、 candidates[ids] 不加入 nums[],则下标 ids + 1,其他对象不变继续递归
b、 candidates[ids] 加入 nums[],若加入不超出target，正常加入, ids 保持不变，target 减除 candidates[ids] ，继续递归，递归结束将 nums[] 中加入的最后一位移除


```