package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 具体的实现化角色 ->Rmvb视频文件
 **/
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("Rmvb视频文件： "+ fileName);
    }
}
