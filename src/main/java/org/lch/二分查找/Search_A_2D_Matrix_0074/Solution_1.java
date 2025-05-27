package org.lch.二分查找.Search_A_2D_Matrix_0074;

public class Solution_1 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSize = rows * cols;
        int left = 0;
        int right = maxSize - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            int curRow = mid / cols;
            int curCol = mid % cols;
            if (matrix[curRow][curCol] == target){
                return true;
            }else if (matrix[curRow][curCol] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
    }
}
