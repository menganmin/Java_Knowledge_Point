package com.mam.principles.dependence.before;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 依赖倒转原则
 **/
public class ComputerDemo {
    public static void main(String[] args) {
        //创建组件对象
        IntelCup cup = new IntelCup();
        KingstonMemory memory = new KingstonMemory();
        XiJieHardDisk hardDisk = new XiJieHardDisk();

        //创建计算机
        Computer computer = new Computer();
        //组装计算机
        computer.setCup(cup);
        computer.setMemory(memory);
        computer.setHardDisk(hardDisk);

        computer.run();
    }
}
