package org.lch.排序算法.Bubble_Sort;

public class Solution {

    // 进行n-1次排序。
    // 每次排序从0~n-1-i(i是次数编号)，检查这个序列中的数，两两相邻的数，如果前面的大于后面的就将它们交换。
    // 这样使得大的数往后面走，每次冒泡就会将一个大的数往后面冒，从而达到目的。
    // 时间复杂度为O(n^2)，空间复杂度为O(1)，稳定
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isChanged = false;
            // 这里j=0，而不是j=i。因为前面并不是已经排好序了，只是将数据往后排而已。
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] >= arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        bubbleSort(ints);
        System.out.println(ints);
    }
}
