package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 扩展抽象化角色 -> windows操作系统
 **/
public class Windows extends OperatingSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
