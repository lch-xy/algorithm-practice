package org.lch.分治丨回溯.N_Queens_051;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_1 {

    List<List<String>> resultList = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> diagonalsOne = new HashSet<>();
    Set<Integer> diagonalsTwo = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        backTracking(n, 0, new ArrayList<>());
        return resultList;
    }

    private void backTracking(int n, int row, List<Integer> queens) {
        if (row == n) {
            resultList.add(generateBoard(queens,n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || diagonalsOne.contains(row - col) || diagonalsTwo.contains(row + col)){
                continue;
            }
            queens.add(col);
            colSet.add(col);
            diagonalsOne.add(row-col);
            diagonalsTwo.add(row+col);

            backTracking(n,row+1,queens);
            queens.remove(queens.size()-1);
            colSet.remove(col);
            diagonalsOne.remove(row-col);
            diagonalsTwo.remove(row+col);
        }
    }

    private List<String> generateBoard(List<Integer> queens, int n){
        List<String> board = new ArrayList<>();

        for (int i = 0; i < queens.size(); i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (j == queens.get(i)){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

}
