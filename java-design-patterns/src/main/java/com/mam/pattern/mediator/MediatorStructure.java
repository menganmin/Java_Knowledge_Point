package com.mam.pattern.mediator;

/**
 * @Author Anmin
 * @Date 2022/12/08
 **/
public class MediatorStructure extends Mediator{

    //聚合租房者跟房主对象
    private Tenant tenant;
    private HouseOwner houseOwner;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    public void constact(String message, Person person) {
        if(person == houseOwner){
            tenant.getMessage(message);
        }else{
            houseOwner.getMessage(message);
        }
    }
}
