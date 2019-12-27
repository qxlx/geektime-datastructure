package com.ncst.sort;

/**
 * @author i
 * @create 2019/12/24 15:50
 * @Description 冒泡排序
 *
 */
public class BubbleSort {

    public static void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
    //交换
    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int [] array = {4,5,6,3,2,1};

        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

}
