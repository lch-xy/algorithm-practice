package org.lch.二分查找.Find_Minimum_In_Rotated_Sorted_Array_0153;

public class Solution_2 {

    // [4,5,6,7,0,1,2]
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                // 最小值一定在右半边（mid 右边）
                left = mid + 1;
            }else {
                // 最小值在左半边（mid 也可能是答案）
                right = mid;
            }
        }
        return nums[left];
    }

}
