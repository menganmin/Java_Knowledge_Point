package com.mam.structures.linked_list;

/**
 * @Author Anmin
 * @Date 2022/12/26
 **/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int num){
        if(num < 1){
            System.out.println("num的值不合法");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号为：" + curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo   表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums      表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数不合法");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if(helper == first){
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈的小孩编号：" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后剩一个小孩在圈中：" + first.getNo());
    }
}

class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
