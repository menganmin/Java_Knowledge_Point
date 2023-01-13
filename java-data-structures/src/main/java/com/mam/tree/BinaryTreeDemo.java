package com.mam.tree;

/**
 * @Author Anmin
 * @Date 2023/01/05
 * 二叉树遍历
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "小白");
        HeroNode node2 = new HeroNode(2, "小黑");
        HeroNode node3 = new HeroNode(3, "小红");
        HeroNode node4 = new HeroNode(4, "小黄");
        HeroNode node5 = new HeroNode(5, "小老弟");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);
        /*System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println("后续遍历");
        tree.postOrder();
        System.out.println("===========");
        System.out.println("前序查找");
        HeroNode resNode = tree.preOrderSearch(5);
        System.out.println(resNode);*/

        System.out.println("=============");
        System.out.println("删除操作前");
        tree.preOrder();
        tree.del(3);
        System.out.println("删除操作后");
        tree.preOrder();
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
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
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
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
    public HeroNode preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.preOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        if (this.right != null){
            resHeroNode = this.right.preOrderSearch(no);
        }
        return resHeroNode;
    }
    //中序遍历
    public HeroNode infixOrderSearch(int no){
        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.infixOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resHeroNode = this.right.infixOrderSearch(no);
        }
        return resHeroNode;
    }
    //后序遍历
    public HeroNode postOrderSearch(int no){
        HeroNode resHeroNode = null;
        if (this.left != null){
            resHeroNode = this.left.postOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        if (this.right != null){
            resHeroNode = this.right.postOrderSearch(no);
        }
        if (resHeroNode != null){
            return resHeroNode;
        }
        if (this.no == no){
            return this;
        }
        return resHeroNode;
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
