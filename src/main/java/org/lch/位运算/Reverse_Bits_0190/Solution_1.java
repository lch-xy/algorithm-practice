package org.lch.位运算.Reverse_Bits_0190;

public class Solution_1 {

    // 从n的最后一位开始拿 从res右边开始放
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;           // 结果左移1位（把旧的空出来）
            result |= (n & 1);      // 拿到 n 的最右边一位，加到结果末尾
            n >>>= 1;               // n 右移1位（抛弃最右边这个处理过的位）
        }
        return result;
    }
}
