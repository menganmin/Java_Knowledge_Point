package com.mam.binarysorttree;

/**
 * @Author Anmin
 * @Date 2023/01/30
 * 二叉排序树
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        tree.infixOrder();

        /*System.out.println("测试删除叶子节点");
        tree.delNode(2);
        tree.infixOrder();*/
        System.out.println("测试删除只有一棵子树的节点");
        tree.delNode(1);
        tree.infixOrder();
    }
}

class BinarySortTree{
    private Node root;

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
