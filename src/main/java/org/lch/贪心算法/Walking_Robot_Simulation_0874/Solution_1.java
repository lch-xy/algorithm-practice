package org.lch.贪心算法.Walking_Robot_Simulation_0874;

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 上-右-下-左
        // 进行方向控制：
        //  -1 右转：dir = (dir + 1) % 4
        //  -2 左转：dir = (dir + 3) % 4
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        int dir = 0;
        int x = 0;
        int y = 0;
        int maxDist = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                // 执行command次，每次走dirs[dir]步
                for (int i = 1; i <= command; i++) {
                    int newX = x + dirs[dir][0];
                    int newY = y + dirs[dir][1];

                    if (set.contains(newX + "," + newY)) break;

                    x = newX;
                    y = newY;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        return maxDist;
    }

}
