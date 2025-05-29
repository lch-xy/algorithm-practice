package org.lch.动态规划.Split_Array_Largest_Sum_0410;

import java.util.Arrays;

public class Solution_1 {

    // 先用二分查找 找到中间的一个数，再对数据今天切割，看能不能分成k段和 小于当前数
    public int splitArray(int[] nums, int k) {
        // 为什么是这里是max而不是min，因为要切割成子序列，那么一定要放下一个数，如果选min的话就一个数都没法放了
        int left = Arrays.stream(nums).max().getAsInt();
        int rifgt = Arrays.stream(nums).sum();

        while (left < rifgt){
            int mid = left + (rifgt - left) / 2;
            // 如果可以切割 就再讲数值缩小找
            if (canSplit(nums,k,mid)){
                rifgt = mid;
            }else {
                left = mid + 1;
            }
        }
        // 在 left < right 的模式下 返回哪个都一样
        return left;
    }

    // 找的是有序的子序列 所以 直接遍历即可
    private boolean canSplit(int[] nums, int k, int mid) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return count <= k;
    }

}
