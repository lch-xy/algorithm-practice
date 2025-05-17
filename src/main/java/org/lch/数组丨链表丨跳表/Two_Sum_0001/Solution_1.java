package org.lch.数组丨链表丨跳表.Two_Sum_0001;

public class Solution_1 {

    // 双层for循环 时间复杂度 O(n²)
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
