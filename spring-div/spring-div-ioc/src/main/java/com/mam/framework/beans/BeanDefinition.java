package com.mam.framework.beans;

import lombok.Data;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * 用来封装bean标签数据
 * id属性
 * class属性
 * property子标签的数据
 **/
@Data
public class BeanDefinition {

    private String id;
    private String className;
    private MutablePropertyValue propertyValue;

    public BeanDefinition() {
        propertyValue = new MutablePropertyValue();
    }

}
