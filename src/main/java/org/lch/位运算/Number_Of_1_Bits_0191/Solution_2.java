package org.lch.位运算.Number_Of_1_Bits_0191;

public class Solution_2 {

    // 位运算
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }

}
