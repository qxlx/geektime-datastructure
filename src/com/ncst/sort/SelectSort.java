package com.ncst.sort;

/**
 * @author i
 * @create 2019/12/24 16:33
 * @Description
 */
public class SelectSort {

    public static void selectSort(int [] array){
        for (int i = 0; i < array.length-1 ; i++) {
            int minIndex = i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int [] array = {4,5,6,3,2,1};

        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

}
