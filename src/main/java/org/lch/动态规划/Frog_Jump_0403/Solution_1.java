package org.lch.动态规划.Frog_Jump_0403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1 {

    // dp + hash
    // dp[i]：表示跳到第 i 个石头（stones[i]）时，所有可能的跳跃步长集合。
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int stone : stones) {
            for (int k : map.get(stone)) {
                // 每次可以跳到这个范围
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }

}
