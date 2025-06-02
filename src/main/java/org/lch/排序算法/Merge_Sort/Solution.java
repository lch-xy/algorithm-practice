package org.lch.排序算法.Merge_Sort;

public class Solution {

    // 先递归到最底层，然后从下往上每次两个序列进行归并合起来，是一个由上往下分开，再由下往上合并的过程
    // 时间复杂度O(nlogn)，稳定
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 新建一个数组可以保持稳定性
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[index++] = arr[j++];
            } else {
                temp[index++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= right) {
            temp[index++] = arr[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        mergeSort(ints);
        System.out.println(ints);
    }

}
