package com.mam.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2023/01/09
 * 赫夫曼树
 **/
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("空树");
        }
    }

    /**
     *
     * @param arr   需要创建成赫夫曼树的数组
     * @return      创建好的赫夫曼树的根节点
     */
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }
        while (nodes.size() > 1){
            //从小到大排序
            Collections.sort(nodes);
            //取出根节点权值最小的节点
            Node leftNode = nodes.get(0);
            //取出权值第二小的节点
            Node rightNode = nodes.get(1);
            //构建父节点
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从list中删除处理过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将parent加入到list里面
            nodes.add(parent);
            //第一次处理后
            System.out.println("第一次处理后:" + nodes);
        }
        //返回root节点信息
        return nodes.get(0);
    }
}
class Node implements Comparable<Node>{
    int value;  //节点权值
    Node left;  //指向左子节点
    Node right; //指向右子节点
    public Node(int value){
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //升序
        return this.value - o.value;
    }

}