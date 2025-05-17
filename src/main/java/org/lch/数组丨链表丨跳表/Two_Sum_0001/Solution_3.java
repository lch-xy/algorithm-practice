package org.lch.数组丨链表丨跳表.Two_Sum_0001;

import java.util.HashMap;

public class Solution_3 {

    // 当我们把数据放入Cache中的时候，可以直接查询之前是否存在补码
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (cache.containsKey(remain)) {
                return new int[]{cache.get(remain), i};
            }
            cache.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11);
        System.out.print("");
    }

}
