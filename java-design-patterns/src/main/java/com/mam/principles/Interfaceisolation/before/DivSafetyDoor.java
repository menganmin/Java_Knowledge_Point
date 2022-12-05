package com.mam.principles.Interfaceisolation.before;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * div安全门
 **/
public class DivSafetyDoor implements SafetyDoor{
    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireProof() {
        System.out.println("防火");
    }

    @Override
    public void waterProof() {
        System.out.println("防水");
    }
}
