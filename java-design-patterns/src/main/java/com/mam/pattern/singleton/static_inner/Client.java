package com.mam.pattern.singleton.static_inner;

import java.io.*;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 测试使用序列化破坏单例模式 - 静态内部类
 **/
public class Client {
    public static void main(String[] args) throws Exception {
        writeObjectToFile();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\wenqian\\Desktop\\anmin\\a.txt"));
        Singleton singleton = (Singleton)ois.readObject();
        System.out.println(singleton);
        ois.close();
    }

    public static void writeObjectToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\wenqian\\Desktop\\anmin\\a.txt"));
        Singleton instance = Singleton.getInstance();
        oos.writeObject(instance);
        oos.close();
    }
}
