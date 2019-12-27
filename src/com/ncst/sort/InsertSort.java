package com.ncst.sort;

/**
 * @author i
 * @create 2019/12/24 16:15
 * @Description
 */
public class InsertSort {

    public static void insertSort(int []arr){
        for (int i = 1; i < arr.length; i++) {//将数组分为2类 一类是已排好序的  一类是未拍好序的 假设 第一个是已排好序的
            int value = arr[i];//记录当前需要插入的数据
            int j = i-1;//在i-1前面的位置找到要插入的位置
            for (; j >=0; j--) {//从i-1个位置 依次判断前面的数是否大于后边的数字
                if (arr[j]>value){//如果前一个数字大于当前的数字 就进行交换位置
                    arr[j+1] = arr[j];//
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int [] array = {4,5,6,3,2,1};

        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
    }

}
