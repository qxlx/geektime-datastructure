package com.ncst.binarysearch;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @author i
 * @create 2020/5/14 21:19
 * @Description
 */
public class BinarySearch {

    public static int search(int [] arr,int target){
        int left = 0, right = arr.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]== target){
                return mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static int search2(int [] arr,int target){
        return search(arr,0,arr.length-1,target);
    }

    private static int search(int[] arr, int left, int right, int target) {
        if (left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if (arr[mid]==target){
            return mid;
        }else if(arr[mid]<target){
            return  search(arr,mid+1,right,target);
        }else {
            return search(arr, left, mid - 1, target);
        }
    }


    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(search2(arr, 5));
    }

}
