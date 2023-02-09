package com.mam.algorithm.kmp;

/**
 * @Author Anmin
 * @Date 2023/02/02
 * kmp算法 -> 解决字符串包含的问题
 **/
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "你好呀。小老弟";
        String str2 = "小老弟";
        int[] next = kmpNext(str2);
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }

    //获取到子串的部分匹配值表
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串是长度为1部分匹配值就是0
        for (int i = 1 , j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     *
     * @param str1  源字符串
     * @param str2  字串
     * @param next  部分匹配表，是子串对应的部分匹配表
     * @return  如果是-1就没有匹配到，否则就返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }
}
