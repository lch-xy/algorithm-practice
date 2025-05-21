package org.lch.栈丨队列丨优先队列丨双端队列.Largest_Rectangle_In_Histogram_0084;

import java.util.Stack;

public class Solution_3 {

    // 使用单调栈 增加哨兵位
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights,0,newHeight,1,heights.length);
        int maxAre = 0;
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int height = newHeight[stack.pop()];
                // 可能当开始就反向递增，会直接弹出会导致栈为空，那么宽度应该是1
                // 矩形宽度 = 右边界 - 左边界 + 1
                //         = (i - 1) - (stack.peek() + 1) + 1
                //         = i - stack.peek() - 1
                int width = i - stack.peek() - 1;
                maxAre = Math.max(maxAre, height * width);
            }
            stack.push(i);
        }
        return maxAre;
    }

    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{1}));
    }
}
