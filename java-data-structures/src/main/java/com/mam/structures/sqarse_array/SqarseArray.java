package com.mam.structures.sqarse_array;

/**
 * @Author Anmin
 * @Date 2022/12/11
 * 稀疏数组
 **/
public class SqarseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0：表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] ints : chessArr1) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        //将二维数组转为稀疏数组
        //先遍历二维数组，得到非0的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到sqarseArr中
        int count = 0;//用于记录是第几个非0的数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组");
        for (int[] ints : sparseArr) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        /*
        将稀疏数组 -> 原始的二维数组
        1.先读取稀疏数组的第一行，创建原始的二维数组表格
        2.在读取稀疏数组后几行，并赋给原始的二维数组
         */
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复后的二维数组");
        for (int[] ints : chessArr2) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
