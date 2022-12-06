package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 具体的实现化角色 ->avi视频文件
 **/
public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件： "+ fileName);
    }
}
