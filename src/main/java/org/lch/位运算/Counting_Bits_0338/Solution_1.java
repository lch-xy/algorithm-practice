package org.lch.位运算.Counting_Bits_0338;

public class Solution_1 {

    // i     二进制    res[i]
    // -----------------------
    // 0     0000     0        // base case
    // 1     0001     res[0] + 1 = 0 + 1 = 1
    // 2     0010     res[1] + 0 = 1 + 0 = 1
    // 3     0011     res[1] + 1 = 1 + 1 = 2
    // 4     0100     res[2] + 0 = 1 + 0 = 1
    // 5     0101     res[2] + 1 = 1 + 1 = 2
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
