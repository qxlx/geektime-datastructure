package com.ncst.sort;


/**
 * @author i
 * @create 2019/12/24 16:39
 * @Description 排序
 * 冒泡排序
 */
public class Sorts {

    /***
     *  冒泡排序
     *  案例: 6 5 4 3 1 2
     *  第一轮
     *      第一次 5 6 4 3 1 2
     *      第二次 5 4 6 3 1 2
     *      第三次 5 4 3 6 1 2
     *      第四次 5 4 3 1 6 2
     *      第五次 5 4 3 1 2 6
     *  第二轮
     *      第一次 4 5 3 1 2 6
     *      第二次 4 3 5 1 2 6
     *      第三次 4 3 1 5 2 6
     *      第四次 4 3 1 2 5 6
     *  第三轮
     *      第一次 3 4 1 2 5 6
     *      第二次 3 1 4 2 5 6
     *      第三次 3 1 2 4 5 6
     *      第四次 3 1 2 4 5 6
     *  第四轮
     *      第一次 1 3 2 4 5 6
     *      第二次 1 2 3 4 5 6
     *      第三次 1 2 3 4 5 6(这里设置一个判断 如果有一次不进行排序 那么整个数组的数据就是有序的)
     *  排序的思想: 两个相邻的元素进行比较，每次选出最大的元素移动至最后 经过多轮操作后 就可以得到一个有序的数组了
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }


    /***
     * 插入排序
     *   数据:6 5 4 3 1 2
     *   第一轮：
     *     第一次：5 6 4 3 1 2   i=1 j=0
     *   第二轮
     *     第一次：4 5 6 3 1 2   i=2 j=1
     *   第三轮
     *     第一次：3 4 5 6 1 2   i=3 j=2
     *   第四轮
     *     第一次  1 3 4 5 6 2   i=4 j=3
     *   第五轮
     *     第一次  1 2 3 4 5 6   i=5 j=4
     *  思路 将要排序的数组 分成已排序和未排序  每次从未排序中取出一个元素 插入到已排序数组对应位置
     * @param array
     *
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    /***
     *  选择排序
     *  思路:通过将数组分为已拍好序的数组和未拍好序的数组 分为两组 每次从未拍好序的数组中选择出最小的数 放到已拍好序的数组中
     *  思想和插入是类似 但是插入是选择一个就插入，选择是选择一个最小的插入
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};

        //bubbleSort2(array);
        //insertSort(array);
        mergeSorts(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void selectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


    public static void mergeSorts(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    private static void mergesort(int[] arr, int p, int r) {
        if (p >= r) return;

        int q = p + (r - p) / 2;

        //合并左边
        mergesort(arr, p, q);
        //合并右边
        mergesort(arr, q + 1, r);

        merge(arr, p, q, r);

    }

    private static void merge(int[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int count = 0;
        //定义一个数组
        int[] tmp = new int[r - p + 1];
        //合并两个数组
        while (i <=q && j<=r) {
            if (arr[i] < arr[j]) {
                tmp[count++] = arr[i++];
            } else {
                tmp[count++] = arr[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        //转移剩余的元素
        while (start <= end) {
            tmp[count++] = arr[start++];
        }
        //回归arr
        for (int k = 0; k <= (r - p); k++) {
            arr[p+k] = tmp[k];
        }
    }

}
