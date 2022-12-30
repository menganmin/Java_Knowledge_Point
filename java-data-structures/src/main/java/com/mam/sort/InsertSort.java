package com.mam.sort;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/28
 * 插入排序
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        /*//定义待插入的数
        int insertValue = arr[1];
        int insertIndex = 1-1;//即arr[1]的前面这个数的下标

        *//*
        1.insertIndex >=0 保证在给insertValue找插入位置，不越界
        2.insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
        3.需要将arr[insertIndex]后移
         *//*
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));

        //第二轮
        insertValue = arr[2];
        insertIndex = 2-1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第二轮插入");
        System.out.println(Arrays.toString(arr));

        //第三轮
        insertValue = arr[3];
        insertIndex = 3-1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第三轮插入");
        System.out.println(Arrays.toString(arr));*/

        //经过上面的推到
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
