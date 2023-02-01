package com.mam.structures.search;

import java.util.Arrays;

/**
 * @Author Anmin
 * @Date 2022/12/30
 * 黄金分割查找法
 **/
public class FibonacciSearch {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};

    }
    //获取一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i -1] + f[i -2];
        }
        return f;
    }

    /**
     * 编写斐波那契查找算法
     * @param a
     * @param key   查找的关键码
     * @return  返回对应的下标，如果没有就返回-1
     */
    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length -1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;
        int[] f = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //使用while来循环处理，找到key
        while (low < high){
            mid = low + f[k-1] -1;
            if (key < temp[mid]){
                high = mid -1;
                k--;
            }else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else{
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
