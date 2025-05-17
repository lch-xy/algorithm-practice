package org.lch.数组丨链表丨跳表.Merge_Sorted_Array_0088;

public class Solution_1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int num1_index = m -1;
        int num2_index = n -1;
        while (num1_index >= 0 && num2_index >= 0){
            if (nums1[num1_index] > nums2[num2_index]){
                nums1[index--] = nums1[num1_index--];
            }else {
                nums1[index--] = nums2[num2_index--];
            }
        }
        while (num2_index >= 0){
            nums1[index--] = nums2[num2_index--];
        }
    }
}
