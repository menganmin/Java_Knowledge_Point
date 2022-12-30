package com.mam.sort;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/28
 * 选择排序
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr){

        /*//第一轮
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        if(minIndex != 0){
            //将最小值，放在arr[0]，交换
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一轮过后");
        System.out.println(Arrays.toString(arr));

        //第二轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        if(minIndex != 1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮过后");
        System.out.println(Arrays.toString(arr));

        //第三轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        if(minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮过后");
        System.out.println(Arrays.toString(arr));*/

        //经过上面的推导过程
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
