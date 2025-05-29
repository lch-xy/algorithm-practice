package org.lch.动态规划.Longest_Valid_Parentheses_0032;

public class Solution_3 {

    // 双指针
    public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right + left);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right + left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }

        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

}
