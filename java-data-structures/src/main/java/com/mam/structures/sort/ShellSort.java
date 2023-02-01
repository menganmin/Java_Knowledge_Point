package com.mam.structures.sort;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/28
 * 希尔排序
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        shellSort2(arr);
    }

    public static void shellSort(int[] arr){
        /*int temp = 0;
        //第一轮
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >=0 ; j -= 5) {
                if(arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        //第二轮
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >=0 ; j -= 2) {
                if(arr[j] > arr[j + 2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));

        //第三轮
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 ; j -= 1) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));*/
        
        //根据据推导
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >=0 ; j -= gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println("希尔排序交换法");
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort2(int[] arr){

        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println("希尔移位法");
        System.out.println(Arrays.toString(arr));
    }
}
