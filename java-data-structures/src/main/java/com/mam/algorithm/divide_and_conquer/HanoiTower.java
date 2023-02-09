package com.mam.algorithm.divide_and_conquer;

/**
 * @Author Anmin
 * @Date 2023/02/02
 * 分支算法 -> 解决汉诺塔问题
 **/
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
    }

    /**
     * 汉诺塔的移动方法  使用分治算法
     * @param num   多少个盘
     * @param a     a柱
     * @param b     b柱
     * @param c     c柱
     */
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else{
            //1.先把最上面的所有盘A -> B,移动过程使用到C
            hanoiTower(num -1,a,c,b);
            //2.把最下边的盘A -> C
            System.out.println("第"+ num +"个盘从 " + a + "->" + c);
            //3.把B所有的盘从B -> C,移动过程使用到A
            hanoiTower(num -1,b,a,c);
        }
    }
}
