package org.lch.栈丨队列丨优先队列丨双端队列.Largest_Rectangle_In_Histogram_0084;

import java.util.Stack;

public class Solution_2 {

    // 使用单调栈
    // 单调递增栈 -> 寻找左右第一个比它小的数
    // 单调递减栈 -> 寻找左右第一个比它大的数
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int maxAre = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                // 可能当开始就反向递增，会直接弹出会导致栈为空，那么宽度应该是1
                // 矩形宽度 = 右边界 - 左边界 + 1
                //         = (i - 1) - (stack.peek() + 1) + 1
                //         = i - stack.peek() - 1
                int width = stack.isEmpty() ? 1 : i - stack.peek() - 1;
                maxAre = Math.max(maxAre, height * width);
            }
            stack.push(i);
        }

        // [1,2,3,4,5,6]
        // 如果全是递增，上面就无法计算了，得这里兜底
        // right 应该是最大值
        while (!stack.isEmpty()) {
            int len = heights.length;
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? len : len - stack.peek() - 1;
            maxAre = Math.max(maxAre, height * width);
        }

        return maxAre;
    }

    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{0}));
    }
}
