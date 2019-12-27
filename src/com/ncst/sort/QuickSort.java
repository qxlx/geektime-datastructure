package com.ncst.sort;

/**
 * @author i
 * @create 2019/12/25 17:35
 * @Description 快速排序
 *
 */
public class QuickSort {

    public static void quickSort(int [] array){
        quickSoryInternally(array,0,array.length-1);
    }

    public static void quickSoryInternally(int [] a,int p,int r){
        if (p>=r)
            return;

        int q = partition(a,p,r);
        quickSoryInternally(a,p,q-1);
        quickSoryInternally(a,q+1,r);
    }

    public static int partition(int [] a,int p,int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j]<pivot){
                ++i;
            }else {
                int temp = a[i];
                a[i++] = a[j];
                a[j] = temp;
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

}
