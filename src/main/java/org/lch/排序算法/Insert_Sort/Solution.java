package org.lch.排序算法.Insert_Sort;

public class Solution {

    // 从左往右遍历数组，每次将当前元素插入到前面已经排好序的那一部分中，使前面部分始终有序。
    // 每次排序都要向左移动，适合数据量较小的数组
    // 时间复杂度O(n²)，稳定
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            // 当前位置的前一个，应该是有序的
            int j = i - 1;

            // 从最后开始向前移动，如果arr[j]>key，左移
            while (j >= 0 && arr[j] > key) {
                // 范围也就是从j 移动到 i
                arr[j + 1] = arr[j];
                j--;
            }

            // 因为前面对比的j，所以这里是j+1
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        insertSort(ints);
        System.out.println(ints);
    }

}