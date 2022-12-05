package com.mam.principles.dependence.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 依赖倒转原则
 **/
public class ComputerDemo {
    public static void main(String[] args) {
        //创建组件对象
        HardDisk hardDisk = new XiJieHardDisk();
        Memory memory = new KingstonMemory();
        Cup cup = new IntelCup();

        //创建计算机对象
        Computer computer = new Computer();
        //组装计算机
        computer.setCup(cup);
        computer.setHardDisk(hardDisk);
        computer.setMemory(memory);
        computer.run();
    }
}
