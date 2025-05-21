package org.lch.栈丨队列丨优先队列丨双端队列.Sliding_Window_Maximum_0239;

import java.util.Arrays;

public class Solution_1 {

    // 暴力求解 Time Limit Exceeded
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            int maxVal = Integer.MIN_VALUE;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
            return new int[]{maxVal};
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k - 1; i < nums.length; i++) {
            int step = 0;
            int maxValue = Integer.MIN_VALUE;
            while (step < k && i - step >= 0) {
                maxValue = Math.max(maxValue, nums[i - step]);
                step++;
            }
            res[index++] = maxValue;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
