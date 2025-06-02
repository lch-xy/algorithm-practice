package org.lch.排序算法.Shell_Sort;

public class Solution {

    // 希尔排序（Shell Sort）是插入排序的改进版本，它通过 分组插入+逐步缩小间隔，把无序数组逐步变得“更局部有序”，从而加速整体排序。
    // 把数组分成几块，每一块进行一个插入排序；
    // 而分块的依据在于增量的选择分好块之后，从gap开始到n，每一组和它前面的元素（自己组内的）进行插入排序；
    // 核心是通过gap区间，来跳跃式的移动而不是一个个移动
    // 时间复杂度O(nlogn) ~ O(n²)，不稳定
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 插入排序的逻辑 所以得从gap开始，因为前面当已经排好序了
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        shellSort(ints);
        System.out.println(ints);
    }

}
