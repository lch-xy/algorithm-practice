package org.lch.数组丨链表丨跳表.Two_Sum_0001;

import java.util.HashMap;

public class Solution_2 {

    // 题目已经说了只有一答案，每个数字只使用一次，但是会出现多个一样的数字
    // 直接用map去做缓存，即使出现一样的数字，也只会存后出现的那么，但我们是从头开始便利的，要么这个数*2=target，要么这个数没啥用。
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (cache.containsKey(target - nums[i]) && i != cache.get(remain)) {
                return new int[]{i, cache.get(remain)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11);
        System.out.print("");
    }

}
