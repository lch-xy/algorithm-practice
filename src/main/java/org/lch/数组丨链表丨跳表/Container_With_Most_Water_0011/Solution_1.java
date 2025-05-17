package org.lch.数组丨链表丨跳表.Container_With_Most_Water_0011;

public class Solution_1 {

    // brute force
    // Time Limit Exceeded
    public static int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

}
