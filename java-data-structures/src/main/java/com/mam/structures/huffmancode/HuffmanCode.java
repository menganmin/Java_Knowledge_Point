package com.mam.structures.huffmancode;


import java.util.*;

/**
 * @Author Anmin
 * @Date 2023/01/09
 * 赫夫曼编码
 **/
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);
        Node root = createHuffmanTree(nodes);
        preOrder(root);
        //生成对应的赫夫曼编码
        Map<Byte, String> codes = getCodes(root);
        System.out.println("生成的赫夫曼编码表：" + codes);
        byte[] zip = zip(contentBytes, codes);
        System.out.println(Arrays.toString(zip));
        System.out.println("=============");

        byte[] bi = huffmanZip(contentBytes);
        System.out.println("压缩后的结果：" + Arrays.toString(bi) + "长度为：" + bi.length);

        byte[] bytes = decode(huffmanCodes, bi);
        System.out.println(new String(bytes).length());
    }

    /**
     *
     * @param huffmanCodes  赫夫曼编码表
     * @param hufffmanBytes 赫夫曼编码得到的数组
     * @return  返回原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] hufffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hufffmanBytes.length; i++) {
            byte b = hufffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == hufffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(b,flag));
        }
        Set<Map.Entry<Byte, String>> entrySet = huffmanCodes.entrySet();
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : entrySet) {
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 0;
            boolean flag = true;
            Byte b = null;
            while (flag){
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null){
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     *  将一个byte转成一个二进制的字符串
     * @param b     传入的byte值
     * @param flag 表示补高位，如果是true，需要补高位，false就表示不补
     * @return      对应的二进制的字符串
     */
    private static String byteToBitString(byte b,boolean flag){
        int temp = b;
        if (flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }
    }


    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node root = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(root);
        byte[] zip = zip(bytes, codes);
        return zip;
    }

    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i+8);
            }
            by[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return by;
    }

    //将赫夫曼编码表存放在map中
    //97 -> 100
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    //赫夫曼树路径，存储叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //方法重载
    private static Map<Byte,String> getCodes(Node node){
        if (node != null){
            getCodes(node.left,"0",stringBuilder);
            getCodes(node.right,"1",stringBuilder);
            return huffmanCodes;
        }else{
            return null;
        }

    }

    /**
     *  将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入在huffmanCodes中
     * @param node  传入节点
     * @param code  路径：左子节点是0，右子节点是1* @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder builder = new StringBuilder(stringBuilder);
        builder.append(code);
        if (node != null){
            if (node.data == null){
                getCodes(node.left,"0",builder);//向左递归
                getCodes(node.right,"1",builder);//向右递归
            }else{
                //说明是叶子节点
                huffmanCodes.put(node.data,builder.toString());
            }
        }
    }

    //前序遍历赫夫曼树
    private static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("空树");
        }
    }

    /**
     *
     * @param bytes 接收字节数组
     * @return      返回一个list，list包含了Node节点信息
     */
    public static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> list = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b,map.getOrDefault(b,0) + 1);
        }
        Set<Byte> keySet = map.keySet();
        for (Byte aByte : keySet) {
            list.add(new Node(aByte,map.get(aByte)));
        }
        return list;
    }

    /**
     *
     * @param nodes 数组，存储这node节点
     * @return      返回只有一个node root节点
     */
    private static Node createHuffmanTree(List<Node> nodes){

        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
class Node implements Comparable<Node>{
    Byte data;//存放数据本身  'a' => 97
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;
    public Node(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right !=null){
            this.right.preOrder();
        }
    }
}