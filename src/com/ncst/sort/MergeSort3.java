package com.ncst.sort;

import java.util.function.LongFunction;

/**
 * @author i
 * @create 2020/3/30 17:57
 * @Description
 */
public class MergeSort3 {

    public static void main(String[] args) {
        int [] arr = {1,5,6,7,9,4};
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(right <=  left){
            return;
        }

        int mid = (left+right) >> 1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int [] temp = new int [right-left+1];

        int i = left, j = mid+1 , k = 0;

        while (i<=mid && j <=right){
            temp[k++] = arr[i]< arr[j] ? arr[i++] : arr[j++];
        }

        while (i<=mid){
            temp[k++] = arr[i++];
        }

        while (j<=right){
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left+p] = temp[p];
        }
    }

}
