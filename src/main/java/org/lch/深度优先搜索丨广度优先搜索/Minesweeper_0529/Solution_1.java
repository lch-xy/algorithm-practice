package org.lch.深度优先搜索丨广度优先搜索.Minesweeper_0529;

public class Solution_1 {

    final int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1},
    };


    // 游戏规则 点击雷就改成X
    // 如果没有点击到雷就往外扩散，直到遇到数字
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            bfs(board, row, col);
        }
        return board;
    }

    private void bfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'E') {
            return;
        }
        int count = countMines(board,row,col);
        if (count > 0){
            board[row][col] = (char) (count + '0');
        }else{
            board[row][col] = 'B';
            for (int[] dir : dirs) {
                bfs(board,row + dir[0],col+dir[1]);
            }
        }
    }

    private int countMines(char[][] board, int row, int col) {
        int count = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length ) {
                continue;
            }
            if (board[newRow][newCol] == 'M'){
                count++;
            }
        }
        return count;
    }
}
