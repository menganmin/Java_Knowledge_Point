package com.mam.linked_list;

/**
 * @Author Anmin
 * @Date 2022/12/22
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "小白", "小白白");
        HeroNode heroNode2 = new HeroNode(2, "小黑", "小嘿嘿");
        HeroNode heroNode3 = new HeroNode(3, "小黄", "小黄黄");
        SingleLinkedList list = new SingleLinkedList();
        /*list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);*/
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);
        list.list();
    }
}


class SingleLinkedList{

    //先初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    //找到当前链表的最后节点
    //将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void  addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("准备添加的编号"+ heroNode.no +"已经存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
