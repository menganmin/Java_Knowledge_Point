package com.mam.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/30
 * 二分查找
 * 数组必须是有序的
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,89,89,1000,1234};
        List<Integer> list = binarySearch(arr, 0, arr.length, 89);
        System.out.println("下标为：" + list);
    }

    /**
     *
     * @param arr   数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findValue 要查找的值
     * @return
     */
    public static List<Integer> binarySearch(int[] arr, int left, int right, int findValue){
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue > midValue){
            return binarySearch(arr,mid + 1,right,findValue);
        }else if(findValue < midValue){
            return binarySearch(arr,left,midValue -1 ,findValue);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findValue){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (true){
                if (temp > arr.length - 1 || arr[temp] != findValue){
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }
}
