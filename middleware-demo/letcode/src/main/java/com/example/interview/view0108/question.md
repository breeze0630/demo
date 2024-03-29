### 面试题 01.08. 零矩阵

```text
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
```
##### 示例 1：
```text
输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```

##### 示例 2：
```text
输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

```

```text
题解：通过暴力遍历，纪录需要清零的坐标，再重新遍历
可优化为使用第一行，第一列纪录对应的列、行是否清零，并用2个临时变量第一行和第一列是否需要清零，

然后进一步优化成一个变量
```