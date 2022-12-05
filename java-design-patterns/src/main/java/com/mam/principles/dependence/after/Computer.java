package com.mam.principles.dependence.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class Computer {
    private HardDisk hardDisk;
    private Cup cup;
    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void run(){
        System.out.println("computer run");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据：" + data);
        cup.run();
        memory.save();
    }
}
