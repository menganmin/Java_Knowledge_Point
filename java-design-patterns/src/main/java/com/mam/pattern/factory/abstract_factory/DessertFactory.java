package com.mam.pattern.factory.abstract_factory;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public interface DessertFactory {

    //生产咖啡的功能
    Coffee createCoffee();
    //生产甜品的功能
    Dessert createDessert();

}
