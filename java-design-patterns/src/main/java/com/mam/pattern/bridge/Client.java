package com.mam.pattern.bridge;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Client {
    public static void main(String[] args) {
        OperatingSystem system = new Mac(new AviFile());
        system.play("海贼王");
    }
}
