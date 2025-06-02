package org.lch.排序算法.Select_Sort;

public class Solition {


    // 在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
    // 再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。
    // 时间复杂度为O(n²)，不稳定
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndx]){
                    minIndx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndx];
            arr[minIndx] = temp;
        }
    }


    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        selectSort(ints);
        System.out.println(ints);
    }

}
