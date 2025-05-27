package org.lch.贪心算法.Jump_Game_II_0045;

public class Solution_2 {

    // 贪心算法，想象成层级跳跃，记录下一次跳跃能到的最大下标
    // 每次到达这个小标意味着已经完成了一次跳跃
    public static int jump(int[] nums) {
        int farthest = 0;
        int curFarthest = 0;
        int step = 0;
        // 为什么是i < nums.length - 1？
        // 因为这里判断是到达最后一格后step++
        // 其实到达最后一格后就不用再跳了 所以不需要遍历到它防止step++
        // 如果只到达了nums.length - 2的话，还是会进行step++
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest,i+nums[i]);

            // 这里就在模拟跳跃的次数
            // curFarthest就是当前这步能到最大长度
            // 超过了这长度 其实就是下一次跳跃了
            if (i == curFarthest){
                step++;
                curFarthest = farthest;
            }
        }
        return step;
    }

    public static void main(String[] args) {
//        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
