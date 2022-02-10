6. Z 字形变换

将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);


示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"


提示：

1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000


答案解析：

1、自己的答案: convert 函数  找出了每个位置的字符串下标和行号的关系，行数为 n, Z 形 每个最上方的均为 2*n-2,中间的值可以用 下标%(2*n-2) 
余数 < n 则余数为行号，余数 >= n ，则 (2*n-2) - n 为行号，
另外方法起始位置中，当字符串长度  <= 行数 || 行数 == 1，可直接返回字符串

2、官方题解:convert1() 函数, 跟随题目意思字符串分布的行号 为 递增 -> 递减 轮询，控制好临界点就能控制行号的改变方向
临界点即为 行号为0 或者行号为 nums -1 