package com.mam.principles.Interfaceisolation.before;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class SafetyDemo {
    public static void main(String[] args) {
        DivSafetyDoor safetyDoor = new DivSafetyDoor();
        safetyDoor.antiTheft();
        safetyDoor.fireProof();
        safetyDoor.waterProof();
    }
}
