package org.lch.排序算法.Quick_Sort;

public class Solution {

    //
    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = partition(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int target = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= target){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i + 1;
    }

    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] ints = {2, 4, 5, 3, 4, 5, 4, 654, 23, 423, 53, 2};
        quickSort(ints);
        System.out.println(ints);
    }

}
