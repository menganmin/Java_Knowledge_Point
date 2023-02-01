package com.mam.structures.tree;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2023/01/06
 * 堆排序
 **/
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行从小到大排序 -> 大顶堆
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        System.out.println("大顶堆排序");
        //将无序序列构建成一个大顶堆
        for (int i = arr.length / 2 +1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素yu末尾元素交换，将最大的元素放置在数组末端
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        int temp = 0;
        for (int j = arr.length -1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组调整成一个大顶堆
     * @param arr   待调整的数组
     * @param i     表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        //k = i * 2 + 1 代表 k是i的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 +1) {
            if (k + 1 < length && arr[k] < arr[k+1]){//左子节点小于右子节点
                k++;//k 指向右子节点
            }
            if (arr[k] > arr[i]){//子节点大于父节点
                arr[i] = arr[k];
                i = k; //k指向i，对k下标下面的左子节点跟右子节点进行循环对比操作
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}
