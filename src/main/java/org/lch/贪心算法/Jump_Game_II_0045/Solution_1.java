package org.lch.贪心算法.Jump_Game_II_0045;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1 {

    // 使用类似bfs的形式，配合visited数组，找到最短路径
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0 );
        int step = 1;

        boolean[] visited = new boolean[nums.length];
        visited[0] = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int index = deque.pollFirst();
                int jump = nums[index];
                if (index + jump >= nums.length - 1) {
                    return step;
                }
                for (int j = index; j <= index + jump; j++) {
                    if (visited[j]){
                        continue;
                    }
                    deque.addLast(j);
                    visited[j] = true;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
