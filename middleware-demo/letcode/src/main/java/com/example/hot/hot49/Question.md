49. 字母异位词分组

```text
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
```

`示例 1:`

```text
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

```

`示例 2:`

```text
输入: strs = [""]
输出: [[""]]
```

`示例 3:`

```text
输入: strs = ["a"]
输出: [["a"]]
```

`提示:`
```text
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
```

`
题解
`
```text
这题问题点在于理解题意：题意为 对于给定的字符串数组，将其中互为 字母异位词的组合在一起，返回


```