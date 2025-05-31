package org.lch.位运算.Power_Of_Two_0231;

public class Solution_2 {

    public boolean isPowerOfTwo(int n) {
        // n & (n - 1) 会将n 最地位的1清除
        // n      =  1100   (十进制 12)
        // n - 1  =  1011   (十进制 11)
        // ----------------------------
        // n & n-1=  1000   (最低位的 1 被清除了)
        return n > 0 && (n & (n - 1)) == 0;
    }

}
