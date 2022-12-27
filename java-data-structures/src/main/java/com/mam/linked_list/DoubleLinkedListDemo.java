package com.mam.linked_list;

/**
 * @Author Anmin
 * @Date 2022/12/26
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("测试双向链表");
        HeroNode2 heroNode1 = new HeroNode2(1, "小白", "小白白");
        HeroNode2 heroNode2 = new HeroNode2(2, "小黑", "小嘿嘿");
        HeroNode2 heroNode3 = new HeroNode2(3, "小黄", "小黄黄");
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.list();
        System.out.println("修改链表");
        HeroNode2 heroNode4 = new HeroNode2(3, "小黄人", "小黄人大眼萌");
        list.update(heroNode4);
        list.list();
        System.out.println("删除链表");
        list.delete(3);
        list.list();
    }
}

class DoubleLinkedList{

    //先初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }

    //遍历双向链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            System.out.println("没找到编号为" + newHeroNode.no+ "的节点");
        }
    }

    public void delete(int no){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("删除的节点"+no+"不存在");
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no,String name,String nickName){
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
