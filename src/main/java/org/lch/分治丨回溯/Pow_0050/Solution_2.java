package org.lch.分治丨回溯.Pow_0050;

public class Solution_2 {

    // 分治法 每次处理n/2的数据
    public static double myPow(double x, int n) {
        long N = n; // 避免 -Integer.MIN_VALUE
        return N >= 0 ? fastPow(x, N) : 1/fastPow(x, -N);
    }

    public static double fastPow(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        // 说明不用再往下递归了
        return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }

}
