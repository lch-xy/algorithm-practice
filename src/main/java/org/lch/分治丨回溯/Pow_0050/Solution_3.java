package org.lch.分治丨回溯.Pow_0050;

public class Solution_3 {

    public static double myPow(double x, int n) {
        long N = n; // 避免 -Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;

        while (N > 0) {
            // 很巧妙 如果是奇数，第一次会走进来，先单独 *x
            // 最后一次也会走进来， * x^(n-1)
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }

}
