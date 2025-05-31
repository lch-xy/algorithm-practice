package org.lch.高级搜索.Sudoku_Solver_0037;

public class Solution_1 {


    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    // 这个递归其实就是对每个为'.'的格子，选择1-9进行填充，然后向下递归，最多会递归N层(N为'.'的数量)，我们用三个数组进行剪枝
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        backTracking(board);
    }

    private boolean backTracking(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int boxIndex = i / 3 * 3 + j / 3;
                    for (char k = '1'; k < '9'; k++) {
                        int num = k - '1';
                        if (!rows[i][num] && !cols[j][num] && !boxes[boxIndex][num]) {
                            board[i][j] = k;
                            rows[i][num] = true;
                            cols[j][num] = true;
                            boxes[boxIndex][num] = true;
                            if (backTracking(board)) return true;
                            board[i][j] = '.';
                            rows[i][num] = false;
                            cols[j][num] = false;
                            boxes[boxIndex][num] = false;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
