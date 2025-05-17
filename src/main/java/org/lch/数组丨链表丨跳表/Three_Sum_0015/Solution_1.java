package org.lch.数组丨链表丨跳表.Three_Sum_0015;

import java.util.*;

public class Solution_1 {

    // 与 Two Sum不一样的是，返回是值而不是index，所以可以先对数组进行排序
    // 先用for循环固定一个数，再使用双指针进行前后遍历
    // 为了防止存在重复数据，需要使用while循环跳过相同的数字
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return resultList;
    }


    public static void main(String[] args) {

//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
//        System.out.println(threeSum(new int[]{0,0,0,0}));
        System.out.println(threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
    }

}
