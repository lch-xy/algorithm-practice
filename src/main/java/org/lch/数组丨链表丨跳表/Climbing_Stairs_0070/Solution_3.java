package org.lch.数组丨链表丨跳表.Climbing_Stairs_0070;

public class Solution_3 {

    // 可以在dp的基础上再简化一下，保留两个值
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int one = 1;
        int two = 2;
        for (int i = 2; i < n; i++) {
            two += one;
            one = two - one;
        }
        return two;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
