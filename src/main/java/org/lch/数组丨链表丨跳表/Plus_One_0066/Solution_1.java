package org.lch.数组丨链表丨跳表.Plus_One_0066;

import java.util.Arrays;

/**
 * @Author: LCH
 * @Date: 2025/5/17 15:22
 */
public class Solution_1 {

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean flag = true;
        while (flag && index >= 0) {
            if (digits[index] + 1 < 10) {
                flag = false;
            }
            digits[index] = (digits[index] + 1) % 10;

            index--;
        }
        if (flag){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits,0,res,1,digits.length);
            return res;
        }
        return digits;
    }

}
