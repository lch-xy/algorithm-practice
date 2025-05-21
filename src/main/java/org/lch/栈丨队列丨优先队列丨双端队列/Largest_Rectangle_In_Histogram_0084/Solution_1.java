package org.lch.栈丨队列丨优先队列丨双端队列.Largest_Rectangle_In_Histogram_0084;

public class Solution_1 {

    // 使用暴力求解 遍历+双指针
    // Time Limit Exceeded
    public static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {

            int left = i, right = i;
            while (left >= 0) {
                if (heights[left] < heights[i] ){
                    break;
                }
                left--;
            }

            while (right <= heights.length - 1) {
                if (heights[right] < heights[i] ){
                    break;
                }
                right++;
            }

            int area = (right-left - 1) * heights[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
