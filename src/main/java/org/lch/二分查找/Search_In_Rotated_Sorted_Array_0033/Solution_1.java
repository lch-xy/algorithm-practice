package org.lch.二分查找.Search_In_Rotated_Sorted_Array_0033;

public class Solution_1 {

    // 判断升序的那边，如果不存在就在另一边
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // 左边有序
            // 这里是 <= 而不是 <
            // 只有两个元素时 或 旋转点正好在右边时 而 <= 可以很好的处理这种情况
            if (nums[left] <= nums[mid]){
                if (nums[left] <= target &&  target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 右边有序
                if (nums[mid] < target &&  target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));
    }

}
