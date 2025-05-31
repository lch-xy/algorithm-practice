package org.lch.位运算.Power_Of_Two_0231;

public class Solution_1 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

}
