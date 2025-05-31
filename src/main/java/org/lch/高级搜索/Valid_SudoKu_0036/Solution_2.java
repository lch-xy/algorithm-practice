package org.lch.高级搜索.Valid_SudoKu_0036;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_2 {

    // 使用数组替代hashmap
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    int boxIndex = i / 3 * 3 + j / 3;

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]){
                        return false;
                    }

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }

}
