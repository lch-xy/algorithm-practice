package org.lch.数组丨链表丨跳表.Climbing_Stairs_0070;

import java.util.HashMap;

public class Solution_1 {

    private static HashMap<Integer, Integer> cache = new HashMap<>();

    // 直接递归求解+memo
    public static int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int one = climbStairs(n - 1);
        cache.put(n - 1, one);

        int two = climbStairs(n - 2);
        cache.put(n - 2, two);

        return one + two;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
