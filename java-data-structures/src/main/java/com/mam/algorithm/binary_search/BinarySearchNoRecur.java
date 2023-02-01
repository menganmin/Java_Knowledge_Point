package com.mam.algorithm.binary_search;

/**
 * @Author Anmin
 * @Date 2023/02/01
 * 二分查找算法（非递归）
 * 要求数列为有序数列
 **/
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr, 1);
        System.out.println(index);
    }

    /**
     *
     * @param arr       待查找的数组，arr是升序
     * @param target    需要查找的树
     * @return          返回对应的下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
