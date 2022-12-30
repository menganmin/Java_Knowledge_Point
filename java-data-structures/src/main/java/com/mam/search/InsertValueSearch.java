package com.mam.search;

/**
 * @Author Anmin
 * @Date 2022/12/30
 * 插值查找算法
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValue(arr, 0, arr.length - 1, 77);
        System.out.println("查找的数的下标为：" + index);
    }

    /**
     *
     * @param arr   数组
     * @param left  左边指针
     * @param right 右边指针
     * @param findValue 查找的值
     * @return
     */
    public static int insertValue(int[] arr,int left,int right,int findValue){
        if(left > right || findValue < arr[0] || findValue > arr[arr.length - 1]){
            return -1;
        }
        int mid = left + (right -left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue){
            return insertValue(arr,mid + 1,right,findValue);
        }else if (findValue < midValue){
            return insertValue(arr,left,mid - 1,findValue);
        }else{
            return mid;
        }
    }
}
