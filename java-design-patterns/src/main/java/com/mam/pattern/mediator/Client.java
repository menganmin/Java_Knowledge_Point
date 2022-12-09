package com.mam.pattern.mediator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class Client {
    public static void main(String[] args) {
        MediatorStructure mediatorStructure = new MediatorStructure();

        //创建租房者跟房主对象
        Tenant tenant = new Tenant("小明",mediatorStructure);
        HouseOwner houseOwner = new HouseOwner("小老弟",mediatorStructure);

        mediatorStructure.setTenant(tenant);
        mediatorStructure.setHouseOwner(houseOwner);

        tenant.constact("我要租房子");
        houseOwner.constact("我有房子可以出租");
    }
}
