package org.lch.数组丨链表丨跳表.Remove_Duplicates_From_Sorted_Array_0026;

public class Solution_1 {

    // 固定一个index，然后遍历数组，遇到与前面不一致的数就赋值给index
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (index == 0 || num > nums[index-1]){
                nums[index++] = num;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
}
