package com.example.hot.hot22;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution().generateParenthesis(2)));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",n,n,res);
        return res;
    }


    public void dfs(String input , int left ,int right ,List<String> res)
    {
        if(left>right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(input);
            return;
        }
        if( left > 0 ){
            dfs(input+"(",left -1,right,res);
        }
        if( right > 0){
            dfs(input+")", left,right-1,res);
        }
    }

}
