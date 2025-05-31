package org.lch.高级搜索.Valid_SudoKu_0036;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1 {

    public boolean isValidSudoku(char[][] board) {
        int m = board.length;

        Map<Integer, Set<Character>> oneMap = new HashMap<>();
        Map<Integer, Set<Character>> twoMap = new HashMap<>();
        Map<String, Set<Character>> threeMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.'){
                    char ch = board[i][j];
                    Set<Character> oneSet = oneMap.getOrDefault(i, new HashSet<>());
                    if (oneSet.contains(ch)){
                        return false;
                    }else {
                        oneSet.add(ch);
                        oneMap.put(i,oneSet);
                    }

                    Set<Character> twoSet = twoMap.getOrDefault(j, new HashSet<>());
                    if (twoSet.contains(ch)){
                        return false;
                    }else {
                        twoSet.add(ch);
                        twoMap.put(j,twoSet);

                    }

                    String key = String.valueOf(i/3) + j/3;

                    Set<Character> threeSet = threeMap.getOrDefault(key, new HashSet<>());
                    if (threeSet.contains(ch)){
                        return false;
                    }else {
                        threeSet.add(ch);
                        threeMap.put(key,threeSet);
                    }
                }
            }
        }
        return true;
    }

}
