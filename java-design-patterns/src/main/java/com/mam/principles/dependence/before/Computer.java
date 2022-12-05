package com.mam.principles.dependence.before;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Computer {
    private IntelCup cup;
    private KingstonMemory memory;
    private XiJieHardDisk hardDisk;

    public IntelCup getCup() {
        return cup;
    }

    public void setCup(IntelCup cup) {
        this.cup = cup;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void run(){
        System.out.println("computer run");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据：" + data);
        cup.run();
        memory.save();
    }
}
