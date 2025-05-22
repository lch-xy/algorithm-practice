package org.lch.栈丨队列丨优先队列丨双端队列.Trapping_Rain_Water_0042;

import java.util.Stack;

public class Solution_1 {

    // [0,1,0,2,1,0,1,3,2,1,2,1]
    public static int trap(int[] height) {
        Stack<Integer> mainStack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!mainStack.isEmpty() && height[mainStack.peek()] < height[i]) {
                // 根据左右的高度，一行行处理
                Integer button = mainStack.pop();
                if (mainStack.isEmpty()){
                    continue;
                }
                int left = mainStack.peek();
                int h = Math.min(height[left], height[i]);
                int w = i - left - 1;
                water += w * (h-height[button]);
            }
            // 入栈作为 下一个的左边
            mainStack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }
}
