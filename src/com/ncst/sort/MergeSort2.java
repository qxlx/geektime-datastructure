package com.ncst.sort;

import java.util.Arrays;
import java.util.function.LongFunction;

/**
 * @author i
 * @create 2020/3/30 17:20
 * @Description 归并排序-简洁版
 */
public class MergeSort2 {

    public static void main(String[] args) {
        int[] array = {5, 8, 9, 4, 2, 3, 1};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }


    private static void mergeSort(int[] array, int left, int right) {
        //条件判断
        if (right <= left) {
            return;
        }
        //中间下标位置
        int mid = (left + right) >> 1;

        //左边排序
        mergeSort(array, left, mid);
        //右边排序
        mergeSort(array, mid + 1, right);
        //合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //临时数组
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, p = 0;

        //比较大小 后存储
        while (i <= mid && j <= right) {
            temp[p++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        //剩余的存储
        while (i <= mid) {
            temp[p++] = array[i++];
        }

        while (j <= right) {
            temp[p++] = array[j++];
        }

        //赋值给原来的数组
        for (int k = 0; k < temp.length; k++) {
            array[left + k] = temp[k];
        }
    }


}
