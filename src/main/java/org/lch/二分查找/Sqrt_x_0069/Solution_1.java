package org.lch.二分查找.Sqrt_x_0069;

public class Solution_1 {

    // 在有序的区间内[0,x] 找到一个最大mid 使 mid * mid <= x
    public static int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 0;
        int right = x;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 防止溢出
            long sqrt = (long) mid * mid;
            if (sqrt == x) {
                return mid;
            } else if (sqrt < x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
