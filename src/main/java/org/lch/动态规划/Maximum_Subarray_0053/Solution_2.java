package org.lch.动态规划.Maximum_Subarray_0053;

public class Solution_2 {

    // [-2,1,-3,4,-1,2,1,-5,4]
    // 贪心 遇到小于0后 直接skip
    public static int maxSubArray(int[] nums) {
        int maxScore = Integer.MIN_VALUE;
        int curScore = 0;
        for (int j = 0; j < nums.length; j++) {
            curScore += nums[j];
            maxScore = Math.max(maxScore, curScore);
            if (curScore < 0) {
                curScore = 0;
            }
        }
        return maxScore;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
