package com.mam.principles.Interfaceisolation.after;

/**
 * @Author Anmin
 * @Date 2022/12/05
 * 接口隔离原则
 **/
public class SafetyDemo {
    public static void main(String[] args) {
        DivSafetyDoor divSafetyDoor = new DivSafetyDoor();
        divSafetyDoor.antiTheft();
        divSafetyDoor.fireProof();
        divSafetyDoor.waterProof();

        System.out.println("================");
        AnminSafetyDoor anminSafetyDoor = new AnminSafetyDoor();
        anminSafetyDoor.antiTheft();
    }
}
