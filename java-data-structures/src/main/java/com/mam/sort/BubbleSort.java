package com.mam.sort;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/28
 * 冒泡排序
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        /*//第一趟排序，将最大的数排到最后面
        int temp = 0;
        for (int j = 0; j < arr.length - 1 - 0; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第二趟排序，就是将第二大的数排到倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，就是将第三大的数排到倒数第三位
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，就是将第四大的数排到倒数第四位
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            if(arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/


    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
