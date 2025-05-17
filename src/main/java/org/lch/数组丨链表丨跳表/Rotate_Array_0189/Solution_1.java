package org.lch.数组丨链表丨跳表.Rotate_Array_0189;

public class Solution_1 {


    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        k = k % len;

        for (int i = 0; i < k; i++) {
            res[i] = nums[len-k+i];
        }
        for (int i = 0; i < len - k; i++) {
            res[k+i] = nums[i];
        }
        // 拷贝数据，不能直接赋值，因为地址会被改掉
        System.arraycopy(res, 0, nums, 0, len);
    }

    public static void main(String[] args) {
       rotate(new int[]{1,2,3,4,5,6,7},3);
    }

}
