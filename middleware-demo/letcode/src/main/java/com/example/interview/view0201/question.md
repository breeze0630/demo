### 面试题 02.01. 移除重复节点


#### 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。


##### 示例1:

```text

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
```


##### 示例2:

```text

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
```


```text
题解中使用一开始使用 List做为缓存，执行时间在500-700ms之间，改为 Set 后，直接降为 5 ms
官方题解比自己的大概快1ms,代码相比较为简洁，利用 set 的不重复特性，重复值 add() 返回 false，少几步操作

进阶的不使用缓冲区的要求（官方和自己的都是这个方式：使用缓冲区），只能用双重循环，所以消耗的时间会很多，大概在 300+ ms

```

```java

// 个人题解
public ListNode removeDuplicateNodes(ListNode head) {
           if(head == null || head.next == null){
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        Set<Integer> list = new HashSet<>();
        ListNode current = head;
        list.add(head.val);
        while (current != null){
            if(current.next == null){
                break;
            }
            if(list.contains(current.next.val)){
                current.next = current.next.next;
            }else {
                list.add(current.next.val);
                current = current.next;
            }
        }
        return first.next;
    }

```
