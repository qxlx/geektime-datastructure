package com.ncst.sort;

import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

/**
 * @author i
 * @create 2020/3/30 21:18
 * @Description
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int [] arr = new int []{2,3,1,5,8,10,6};
        quickSort(arr,0,6);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(end <= start){
            return;
        }

        int piovt = partition(arr,start,end);
        quickSort(arr,start,piovt-1);
        quickSort(arr,piovt+1,end);
    }

    private static int partition(int[] arr, int start, int end) {
        //piovt 标杆位置， counter 小于piovt的元素的个数
        int piovt = end;
        int counter = start;
        for (int i = start; i < end; i++) {
            if (arr[i]<arr[piovt]){
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp  = arr[piovt];
        arr[piovt] = arr[counter];
        arr[counter] = temp;
        return counter;
    }

}
