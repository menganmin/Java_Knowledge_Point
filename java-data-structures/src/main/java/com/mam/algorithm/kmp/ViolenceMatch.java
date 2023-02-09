package com.mam.algorithm.kmp;

/**
 * @Author Anmin
 * @Date 2023/02/02
 **/
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "你好呀。小老弟";
        String str2 = "小老弟";
        int index = violenceMatch(str1, str2);
        System.out.println(index);
    }

    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//指向s1的索引
        int j = 0;//指向s2的索引
        while (i < s1Len && j< s2Len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else{
                i = i - (j-1);
                j = 0;
            }
        }

        if (j == s2Len){
            return i-j;
        }else{
            return -1;
        }
    }
}
