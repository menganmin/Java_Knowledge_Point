package com.mam.structures.tree;

/**
 * @Author Anmin
 * @Date 2023/01/05
 * 顺序存储二叉树
 * 特点：
 *  1.顺序二叉树通常只考虑完全二叉树
 *  2.第n个元素得左子节点为 2*n+1
 *  3.第n个元素的右子节点为 2*n+2
 *  4.第n个元素的父节点为（n-1)/2
 *
 *  n表示二叉树中的第几个元素（按0开始编号）
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.preOrder();
    }
}

class ArrayBinaryTree{
    private int[] arr;

    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }

    /**
     *  顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        //向左递归
        if ((2 * index + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        //向右递归
        if ((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }
    //重载preOrder
    public void preOrder(){
        this.preOrder(0);
    }
}
