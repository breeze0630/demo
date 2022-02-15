### 面试题 03.04. 化栈为队

##### 实现一个MyQueue类，该类用两个栈来实现一个队列。

##### 示例：

```text
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false

```

```text
说明：

    你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

```

```text

MyQueue1 利用LinkedList ,但是使用了push，pop，peek 以外的函数，不标准
MyQueue 通过2个栈，入栈将对象压入 inStack, 需要弹出时，从 outStack 中弹出，弹出前检查outStack是否不为空，为空时，将压入的全部推到outStack中
```