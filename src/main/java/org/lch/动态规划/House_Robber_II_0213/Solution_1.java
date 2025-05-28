package org.lch.动态规划.House_Robber_II_0213;

public class Solution_1 {

    // 拆分成两种情况取最大值  nums[0 ~ n-2] 和 nums[1 ~ n-1]
    // 为什么可以这么拆分来求解？策略是静态定义的，不是动态路径里是否偷东西。
    // rob(0 ~ n-2) 的计算中，如果最终不偷 n-2，是否就可以偷 n-1，从而形成更优解？这种情况会不会被漏掉？
    // 你一旦选择 rob(0 ~ n-2)，就等于“完全排除偷 n-1”的策略，不管中间偷不偷 n-2，都不能反悔去偷 n-1。
    // 而担心的「不偷 n-2，偷 n-1」的情况，其实已经包含在 rob(1 ~ n-1) 中了。
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);

        return Math.max(robRange(nums,0,n-2) ,robRange(nums,1,n-1));
    }

    private int robRange(int[] nums, int start, int end) {
        int pre2 = 0;
        int pre1 = 0;

        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1,pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
