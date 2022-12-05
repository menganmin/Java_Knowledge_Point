package com.mam.pattern.singleton.typical;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * RunTime是典型的单例模式
 **/
public class RunTimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("ipconfig");
        InputStream execInputStream = exec.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = execInputStream.read(bytes);
        System.out.println(new String(bytes,0,len,"GBK"));
    }
}
