package com.example.hot.hot3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwsyz1234567890~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:ZXCVBNM<>?今天你在什么地方等" +
                "我不错真的很好啊可以呢黑白洪城红橙黄绿青蓝紫色涩瑟铯啬渋歮阿吖嗄锕腌额饿の哦恶呃鹅厄俄鄂娥讹噢喔无午五伍误务勿吴物舞武雾"
                +"已一亿①义移医姨疑意议论易";
        System.out.println(new Solution().lengthOfLongestSubstring5(s));
    }
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring(String s) {
        List<String> charList = new ArrayList<>();
        if(s.length() <= 1){
            return s.length();
        }
        int index = 0;
        int result = 0;
        while ( index < s.length() ){
            String  a = s.substring(index,index+1);
            if(charList.contains(a) ){
                if( result < charList.size())
                    result = charList.size();
                while (true){
                    if(charList.get(0).equals(a)){
                        charList.remove(0);
                        break;
                    }
                    charList.remove(0);
                }
            }
            charList.add(a);
            index++;
        }
        if(charList.size()>result){
            return charList.size();
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {

        return 0;
    }

    public int lengthOfLongestSubstring3(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
    public int lengthOfLongestSubstring5(String s) {
        int n = s.length();
        if(n == 0) {    //如果为空字符串，直接返回0
            return 0;
        }
        //因为本题中字符串只含有英文字母，符号和数字，所以可以使用数组来代替哈希表，提高效率。
        int[] num = new int[128];
        int res = 0;
        //left: 左指针    right: 右指针
        int left = 0, right = 0;
        //将字符串转换为一个char数组,写起来方便
        char[] cs = s.toCharArray();

        while(right < n) {
            //每次循环都将右侧指针向前移动一位，并将右侧指针所指向的字符的数量增加1
            //(byte) cs[right]表示将字符cs[right]转换为其所对应的ASCII码，在0~127之间，
            //恰好可以使用byte表示
            num[(byte) cs[right]]++;
            //如果此时右侧指针所对应的字符的数量超过1，表示已经有了重复字符，将左指针右移
            while(num[(byte) cs[right]] > 1) {
                num[(byte) cs[left++]]--;
            }
            //更新结果，取之前的结果与当前窗口长度的最大值
            res = Math.max(res, right - left + 1);
            //右指针右移
            right++;
        }
        return res;
    }


}
