package com.example.springlearndemo.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 四则运算
 * 支持一般的四则运算，支持小数,不支持负数, 例如 4 * ( 10 + 1 ) + 1 #
 * 结果为 51
 * 符号 # 代表 算式结束，必须以 # 结束
 * 符号间必须以空格分割
 * 计算时未处理异常，建议在调用时捕获异常
 */
public class EvaluateExpression {

    // 运算符优先级关系表
    private Map<String, Map<String, String>> priorityMap = new HashMap<String, Map<String, String>>();
    private LinkedList<String> optStack = new LinkedList<String>();
    // 运算符栈
    private LinkedList<Double> numStack = new LinkedList<Double>();
// 操作数栈

    /**
     * 计算表达式
     *
     * @param exp 四则运算表达式, 每个符号必须以空格分隔
     * @return
     */
    public double calcualte(String exp) {
        try {
            StringTokenizer st = new StringTokenizer(exp);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                process(token);
            }
            return numStack.pop();
        }catch (Exception e){
            return Double.MIN_NORMAL;
        }

    }

    /**
     * 读入一个符号串。
     * 如果是数字，则压入numStack
     * 如果是运算符，则将optStack栈顶元素与该运算符进行优先级比较
     * 如果栈顶元素优先级低，则将运算符压入optStack栈,如果相同，则弹出左括号，如果高，则取出２个数字，取出一个运算符执行计算，然后将结果压入numStack栈中
     *
     * @param token
     */
    private void process(String token) {
        while (false == "#".equals(optStack.getFirst()) || false == token.equals("#")) {
// token is numeric
            if (true == isNumber(token)) {
                numStack.push(Double.parseDouble(token));
                break;
// token is operator
            } else {
                String priority = priority(optStack.getFirst(), token);
                if ("<".equals(priority)) {
                    optStack.push(token);
                    break;
                } else if ("=".equals(priority)) {
                    optStack.pop();
                    break;
                } else {
                    double res = calculate(optStack.pop(), numStack.pop(), numStack.pop());
                    numStack.push(res);
                }
            }
        }
    }

    /**
     * 执行四则运算
     *
     * @param opt
     * @param n1
     * @param n2
     * @return
     */
    private double calculate(String opt, double n1, double n2) {
        if ("+".equals(opt)) {
            return n2 + n1;
        } else if ("-".equals(opt)) {
            return n2 - n1;
        } else if ("*".equals(opt)) {
            return n2 * n1;
        } else if ("/".equals(opt)) {
            return n2 / n1;
        } else {
            throw new RuntimeException("unsupported operator:" + opt);
        }
    }

    /**
     * 检查一个String是否为数字
     *
     * @param token
     * @return
     */
    private boolean isNumber(String token) {
        int LEN = token.length();
        for (int ix = 0; ix < LEN; ++ix) {
            char ch = token.charAt(ix);
// 跳过小数点
            if (ch == '.') {
                continue;
            }
            if (false == isNumber(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查一个字符是否为数字
     *
     * @param ch
     * @return
     */
    private boolean isNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    /**
     * 查表得到op1和op2的优先级
     *
     * @param op1 运算符1
     * @param op2 运算符2
     * @return ">", "<" 或 "="
     */
    public String priority(String op1, String op2) {
        return priorityMap.get(op1).get(op2);
    }

    /**
     * 构造方法，初始化优先级表
     */
    public EvaluateExpression() {
// initialize stack
        optStack.push("#");
// initialize priority table
// +
        Map<String, String> subMap = new HashMap<String, String>();
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("+", subMap);
// -
        subMap = new HashMap<String, String>();
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("-", subMap);
// *
        subMap = new HashMap<String, String>();
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("*", subMap);
// /
        subMap = new HashMap<String, String>();
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
        subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put("/", subMap);
// (
        subMap = new HashMap<String, String>();
        subMap.put("+", "<");
        subMap.put("-", "<");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
        subMap.put(")", "=");
//subMap.put("#", ">");
        priorityMap.put("(", subMap);
// )
        subMap = new HashMap<String, String>();
        subMap.put("+", ">");
        subMap.put("-", ">");
        subMap.put("*", ">");
        subMap.put("/", ">");
//subMap.put("(", "<");
        subMap.put(")", ">");
        subMap.put("#", ">");
        priorityMap.put(")", subMap);
// #
        subMap = new HashMap<String, String>();
        subMap.put("+", "<");
        subMap.put("-", "<");
        subMap.put("*", "<");
        subMap.put("/", "<");
        subMap.put("(", "<");
//subMap.put(")", ">");
        subMap.put("#", "=");
        priorityMap.put("#", subMap);
    }

/*    public static void main(String[] args) {
        String exp = " 4 * ( 10 - ( 1 * 2 ) ) + 1.2 #";
        EvaluateExpression ee = new EvaluateExpression();
        System.out.println(ee.calcualte(exp));
    }*/
}
