package org.lch.数组丨链表丨跳表.Plus_One_0066;

/**
 * @Author: LCH
 * @Date: 2025/5/17 15:22
 */
public class Solution_2 {

    // 优化后的代码 移除 flag 直接通过循环条件和逻辑判断是否需要继续进位
    // 如果需要进位，那后面肯定都是0
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            digits[index]++;
            if (digits[index] < 10) {
                return digits;
            } else {
                digits[index] = 0;
            }
            index--;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
