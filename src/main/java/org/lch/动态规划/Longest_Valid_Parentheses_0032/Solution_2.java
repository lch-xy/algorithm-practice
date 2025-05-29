package org.lch.动态规划.Longest_Valid_Parentheses_0032;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2 {

    // dp[i] 表示：以 s[i] 结尾的最长有效括号子串的长度
    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }

        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
