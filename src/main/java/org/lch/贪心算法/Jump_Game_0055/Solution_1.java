package org.lch.贪心算法.Jump_Game_0055;

public class Solution_1 {

    // 定义一个最远距离farthest，
    // 遍历nums数组，如果i>farthest 说明不可达
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) return true;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
