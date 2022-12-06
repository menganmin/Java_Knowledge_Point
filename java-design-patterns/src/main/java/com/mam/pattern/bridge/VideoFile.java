package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 * 实现化角色 -> 视频文件
 **/
public interface VideoFile {

    //解码功能
    public void decode(String fileName);
}
