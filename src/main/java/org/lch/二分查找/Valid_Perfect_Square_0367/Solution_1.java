package org.lch.二分查找.Valid_Perfect_Square_0367;

public class Solution_1 {


    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
