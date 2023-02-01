package com.mam.structures.tree;

/**
 * @Author Anmin
 * @Date 2023/01/05
 * 线索化二叉树
 *  1.n个节点的二叉链表中含有n+1【公式：2n-(n-1) = n+1】个空指针域
 **/
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        HeroNode2 root = new HeroNode2(1, "小白");
        HeroNode2 node2 = new HeroNode2(3, "小红");
        HeroNode2 node3 = new HeroNode2(6, "小黄");
        HeroNode2 node4 = new HeroNode2(8, "小黑");
        HeroNode2 node5 = new HeroNode2(10, "小绿");
        HeroNode2 node6 = new HeroNode2(14, "小老弟");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //创建中序线索化对象
        BinaryTree2 tree2 = new BinaryTree2();
        tree2.setRoot(root);
        tree2.threadedNodes();
        //测试
        HeroNode2 leftNode = node5.getLeft();
        System.out.println("10号节点的前驱节点是："+leftNode);
        HeroNode2 rightNode = node5.getRight();
        System.out.println("10号节点的后继节点是："+rightNode);

        System.out.println("遍历线索化二叉树");
        tree2.threadedList();
    }
}

class BinaryTree2{
    private HeroNode2 root;
    //为了实现线索化，需要创建要给当前节点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前驱节点
    private HeroNode2 pre = null;

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedList(){
        //定义一个变量，存储当前遍历得节点，从root开始
        HeroNode2 node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            //如果当前节点得右指针指向得是后继节点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    /**
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode2 node){
        //如果node是null，不能线索化
        if (node == null){
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，都让当前节点作为下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());
    }

    //前序遍历
    public void preOrder(){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后续遍历
    public void postOrder(){
        if (root != null){
            root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode2 preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //中序查找
    public HeroNode2 infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //后序查找
    public HeroNode2 postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

    //后续删除
    public void del(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else{
                root.del(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }

}

class HeroNode2{
    private int no;
    private String name;
    private HeroNode2 left;//指向左子树
    private HeroNode2 right;//指向右子树

    //如果leftType == 0 表示指向左子树，如果是1表示指向前驱节点
    private int leftType;
    private int rightType;

    public HeroNode2(int no,String name){
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后续遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找

    /**
     * @param no 要查找的编号
     * @return  找到就返回对象，没找到就返回noll
     */
    public HeroNode2 preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode2 resHeroNode2 = null;
        if (this.left != null){
            resHeroNode2 = this.left.preOrderSearch(no);
        }
        if (resHeroNode2 != null){
            return resHeroNode2;
        }
        if (this.right != null){
            resHeroNode2 = this.right.preOrderSearch(no);
        }
        return resHeroNode2;
    }
    //中序遍历
    public HeroNode2 infixOrderSearch(int no){
        HeroNode2 resHeroNode2 = null;
        if (this.left != null){
            resHeroNode2 = this.left.infixOrderSearch(no);
        }
        if (resHeroNode2 != null){
            return resHeroNode2;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resHeroNode2 = this.right.infixOrderSearch(no);
        }
        return resHeroNode2;
    }
    //后序遍历
    public HeroNode2 postOrderSearch(int no){
        HeroNode2 resHeroNode2 = null;
        if (this.left != null){
            resHeroNode2 = this.left.postOrderSearch(no);
        }
        if (resHeroNode2 != null){
            return resHeroNode2;
        }
        if (this.right != null){
            resHeroNode2 = this.right.postOrderSearch(no);
        }
        if (resHeroNode2 != null){
            return resHeroNode2;
        }
        if (this.no == no){
            return this;
        }
        return resHeroNode2;
    }

    //后续删除
    public void del(int no){
        if (this.left !=null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right !=null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.del(no);
        }
        if (this.right != null){
            this.right.del(no);
        }

    }
}