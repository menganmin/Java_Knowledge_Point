package com.mam.algorithm.dynamic;

/**
 * @Author Anmin
 * @Date 2023/02/02
 * 动态规划 -> 背包问题
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价格
        int m = 4;//背包的容量
        int n  = val.length;//物品的个数

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大值
        int[][] v = new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];
        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置为0
        }

        for (int i = 1; i < v.length; i++) {//不处理第一行 i是从1开始的
            for (int j = 1; j < v[0].length; j++) {//不处理第一列，j是从1开始的
                if (w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //v[i][j] = Math.max(v[i-1][j],val[i-1] + v[i-1][j-w[i-1]]);
                    if (v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0){
            if (path[i][j] == 1){
                System.out.println("第" + i + "个商品放入到背包中");
                j -= w[i-1];
            }
            i--;
        }
    }
}
