package com.mam.search;

/**
 * @Author Anmin
 * @Date 2022/12/30
 * 线性查找
 **/
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr, 11);
        if (index == -1){
            System.out.println("未找到");
        }else{
            System.out.println("找到：" + index);
        }
    }
    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
