package com.mam.structures.avl;

/**
 * @Author Anmin
 * @Date 2023/01/30
 * 平衡二叉树
 **/
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println("平衡的二叉树");
        System.out.println("树的高度为：" + tree.getRoot().height());
        System.out.println("树的左子树高度为：" + tree.getRoot().leftHeight());
        System.out.println("树的右子树高度为：" + tree.getRoot().rightHeight());

    }
}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的节点
    public Node search(int value){
        if (root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    //查找要删除的节点的父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else{
            //先找到当前节点信息
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //如果要删除的是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                //判断targetNode是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                int min = delRightTreeMin(targetNode.right);
                targetNode.value = min;
            }else{//删除只有一棵子树的节点
                if (targetNode.left != null){
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                        }else{
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else{
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }
                }
            }
        }

    }

    //添加节点的方法
    public void add(Node node){
        if (this.root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("当前二叉树为空");
        }
    }

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前节点的高度，以当前节点为树的根节点
     * @return
     */
    public int height(){
        return Math.max(left == null?0:left.height(),right == null?0:right.height()) + 1;
    }

    //左旋转方法
    private void leftRotate(){
        //创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成带你过去节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }

    //右旋转方法
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 查找要删除的节点
     * @param value 希望删除的节点的值
     * @return  返回该节点对象
     */
    public Node search(int value){
        if (this.value == value){
            return this;
        }else if (value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除的父节点的信息
     * @param value 节点的值
     * @return      返回要删除的父节点的信息，没有就返回null
     */
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }
        //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
        if (value < this.value && this.left != null){
            return this.left.searchParent(value);//向左子树递归查找
        }else if (value >= this.value && this.right != null){
            return this.right.searchParent(value);//向右子树递归查找
        }else{
            return null;
        }
    }

    //添加节点的方法
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else{
                //递归向左子树添加
                this.left.add(node);
            }
        }else{
            if (this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
        if (rightHeight() - leftHeight() > 1){//左旋转
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return;
        }
        if (leftHeight() - rightHeight() > 1){//右旋转
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()){
                //先对当前节点的左子节点 -》左旋
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            }else{
                rightRotate();
            }
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
}

