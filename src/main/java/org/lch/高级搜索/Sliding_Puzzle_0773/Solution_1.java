package org.lch.高级搜索.Sliding_Puzzle_0773;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution_1 {

    // 这里存的是索引之间可以相互移动的关系
    int[][] neighbor = new int[][]{
            {1, 3},       // 0
            {0, 2, 4},    // 1
            {1, 5},       // 2
            {0, 4},       // 3
            {1, 3, 5},    // 4
            {2, 4}        // 5
    };

    // 这题本质上也是一个字符之间的替换，求最小步数，直接用bfs即可
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";

        Set<String> visited = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(start);
        visited.add(start);

        int step = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String top = deque.pollFirst();
                if (target.equals(top)) return step;
                int zeroIndex = top.indexOf('0');
                for (int next : neighbor[zeroIndex]) {
                    char[] charArray = top.toCharArray();
                    char temp = charArray[next];
                    charArray[next] = charArray[zeroIndex];
                    charArray[zeroIndex] = temp;

                    String newStr = new String(charArray);
                    if (!visited.contains(newStr)){
                        visited.add(newStr);
                        deque.add(newStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
