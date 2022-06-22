### 面试题 02.05. 链表求和

```text
给定两个用链表表示的整数，每个节点包含一个数位。

这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。
```

##### 示例：

```text
输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
```

```text
进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
```
###### 示例：

```text
输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
```

```text
题解：
    直接遍历两个链表，最后判断临时和是否需要加到链尾
    
    进阶中提到的如果是正向存放，只需要将链表倒置，或者用栈，再计算，本质还是让链表倒转，从个位开始计算
```