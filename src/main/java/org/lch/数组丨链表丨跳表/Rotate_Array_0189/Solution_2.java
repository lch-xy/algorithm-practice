package org.lch.数组丨链表丨跳表.Rotate_Array_0189;

public class Solution_2 {

    // 进行三次翻转
    // [1,2,3,4,5,6,7]
    // [7,6,5,4,3,2,1]
    // [5,6,7,4,3,2,1]
    // [5,6,7,1,2,3,4]
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }


    private static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//       rotate(new int[]{1,2,3,4,5,6,7},3);
       rotate(new int[]{1},3);
    }

}
