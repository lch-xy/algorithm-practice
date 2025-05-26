package org.lch.分治丨回溯.Pow_0050;

public class Solution_1 {

    // Time Limit Exceeded
    public static double myPow(double x, int n) {
        double res = 1;
        boolean flag = false;
        if ( n < 0) {
            n *= -1;
            flag = true;
        }
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        if (flag){
            res = 1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }

}
