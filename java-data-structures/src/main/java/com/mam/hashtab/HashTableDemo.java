package com.mam.hashtab;

import java.util.Scanner;

/**
 * @Author Anmin
 * @Date 2022/12/30
 **/
public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出程序");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name){
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;//后移
        }
        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null){
            System.out.println("第"+(no +1)+"链表为空");
            return;
        }
        Emp curEmp = head;
        while (true){
            System.out.print("第"+(no +1)+"链表为:");
            System.out.println("id为："+curEmp.id + ",name为：" + curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id){
        if (head == null){
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //计算存放在哪个EmpLinkedList[] 的函数
    public int hashFun(int id){
        return id % size;
    }
    
    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.println("在第"+(empLinkedListNo + 1)+"条链表中找到了雇员，id:" + emp.id +"，姓名：" + emp.name);
        }else{
            System.out.println("未找到该雇员信息");
        }
    }
}
