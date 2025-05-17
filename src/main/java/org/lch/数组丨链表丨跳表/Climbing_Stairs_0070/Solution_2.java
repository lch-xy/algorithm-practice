package org.lch.数组丨链表丨跳表.Climbing_Stairs_0070;

public class Solution_2 {

    // 既然可以用递归，那么一定可以用dp来做
    // Time Limit Exceeded
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
