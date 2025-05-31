package org.lch.位运算.Number_Of_1_Bits_0191;

public class Solution_1 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            int i = n % 2;
            if (i == 1){
                count++;
            }
            n /= 2;
        }
        return count;
    }

}
