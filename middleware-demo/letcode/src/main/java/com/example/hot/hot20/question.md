20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。

左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"

输出：true

示例 2：

输入：s = "()[]{}"

输出：true

示例 3：


输入：s = "(]"

输出：false

示例 4：

输入：s = "([)]"

输出：false

示例 5：

输入：s = "{[]}"

输出：true


提示：

1 <= s.length <= 104

s 仅由括号 '()[]{}' 组成


解题思路：

队列，先进后出，逐个判断字符，队尾如果和接下来的能匹配括号，则推出队尾并继续下一轮循环，否则压入队尾，遍历结束，判断队列是否清空了，清空则为匹配完，否则未匹配