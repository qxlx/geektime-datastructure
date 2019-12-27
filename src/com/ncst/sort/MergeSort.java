package com.ncst.sort;

import java.util.Arrays;

/**
 * @author i
 * @create 2019/12/25 16:27
 * @Description 归并排序的思想
 *  归并排序的思想 通过将一个无序的数组 分成多个小的数组 将小的数组排序好 最终合并成为一个完整的数组。
 */
public class MergeSort {

    public static void mergSort(int[] array) {
        //参数 0-length-1 进行分解
        mergeSortInternally(array, 0, array.length - 1);
    }

    public static void mergeSortInternally(int[] a, int p, int r) {
       // System.out.println("a:"+Arrays.toString(a)+"\tp:"+p+"\tr:"+r);
        //如果p>=r了 说明停止归并操作
        if (p >= r)
            return;
        //获取中间下标
        int q = p + (r - p) / 2;
        //将a数组p - q 位置进行再次分解
        mergeSortInternally(a, p, q);
        //将a数组q+1 - r位置进行分解
        mergeSortInternally(a, q + 1, r);
        //最终合并
        merg(a, p, q, r);
    }

    public static void merg(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;//初始化变量
        int[] kmp = new int[r - p + 1]; //声明一个大小为r-p+1的数组
        while (i <= q && j <= r) {//将数据添加到a中
            if (a[i] <= a[j]) {
                kmp[k++] = a[i++];
            } else {
                kmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            kmp[k++] = a[start++];
        }
        System.out.println(Arrays.toString(kmp));

        for (i = 0; i <= r - p; ++i) {
            a[p + i] = kmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 11, 3, 9, 8,7};
        mergSort(array);
        System.out.println(Arrays.toString(array));
    }

}
