package org.lch.动态规划.Longest_Valid_Parentheses_0032;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1 {

    // 使用stack进行处理
    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 存的是index
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // 无法匹配 index 前移
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // 这里要+1 因为是两个索引相减算长度
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
