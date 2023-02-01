package com.mam.structures.sort;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/30
 * 基数排序（桶位排序）
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr){

        /*//定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少数据，定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCount = new int[10];
        //第一轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照这个桶的顺序
        int index = 0;
        //遍历每一个桶，并将桶中的数组，存放到原本的数组中
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，放入到原数组
            if (bucketElementCount[k] != 0){
                //循环该桶
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理完后，需要将bucketElementCount[k] = 0
            bucketElementCount[k] = 0;
        }
        System.out.println("第一轮排序："+Arrays.toString(arr));

        //第二轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的十位
            int digitOfElement = arr[j] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照这个桶的顺序
        index = 0;
        //遍历每一个桶，并将桶中的数组，存放到原本的数组中
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，放入到原数组
            if (bucketElementCount[k] != 0){
                //循环该桶
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }
        System.out.println("第二轮排序："+Arrays.toString(arr));

        //第三轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的百位
            int digitOfElement = arr[j] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }
        //按照这个桶的顺序
        index = 0;
        //遍历每一个桶，并将桶中的数组，存放到原本的数组中
        for (int k = 0; k < bucketElementCount.length; k++) {
            //如果桶中有数据，放入到原数组
            if (bucketElementCount[k] != 0){
                //循环该桶
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCount[k] = 0;
        }
        System.out.println("第三轮排序："+Arrays.toString(arr));*/

        //根据上面的推导，可得
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少数据，定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCount = new int[10];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }
            //按照这个桶的顺序
            int index = 0;
            //遍历每一个桶，并将桶中的数组，存放到原本的数组中
            for (int k = 0; k < bucketElementCount.length; k++) {
                //如果桶中有数据，放入到原数组
                if (bucketElementCount[k] != 0){
                    //循环该桶
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理完后，需要将bucketElementCount[k] = 0
                bucketElementCount[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮排序："+Arrays.toString(arr));
        }
    }
}
