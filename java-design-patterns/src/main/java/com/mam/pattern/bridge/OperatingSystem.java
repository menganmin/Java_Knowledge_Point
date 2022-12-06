package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 抽象化角色 ->操作系统
 **/
public abstract class OperatingSystem {

    //声明实现化角色变量
    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
