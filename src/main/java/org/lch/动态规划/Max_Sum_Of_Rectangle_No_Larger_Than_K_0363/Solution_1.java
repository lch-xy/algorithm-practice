package org.lch.动态规划.Max_Sum_Of_Rectangle_No_Larger_Than_K_0363;

import java.util.TreeSet;

public class Solution_1 {

    // 因为是矩形，所以可以固定一段连续的行，把这几行每一列的和加起来，变成一个一维数组，然后再从这个数组中找最大子数组和 ≤ k。
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int top = 0; top < m; top++) {
            // 这是压缩出来的新数组
            int[] colSum = new int[n];
            for (int buttom = top; buttom < m; buttom++) {
                for (int col = 0; col < n; col++) {
                    colSum[col] += matrix[buttom][col];
                }

                // 最大子数组和 ≤ k 使用前缀和+TreeSet
                // 我们在寻找某个之前的前缀和 s，使得 当前前缀和 - s <= k，也就是 s >= 当前前缀和 - k。
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                int sum = 0;
                for (int val : colSum) {
                    sum += val;
                    Integer target = treeSet.ceiling(sum - k);
                    if (target != null){
                        max = Math.max(max,sum - target);
                    }
                    treeSet.add(sum);
                }
            }
        }
        return max;
    }

}
