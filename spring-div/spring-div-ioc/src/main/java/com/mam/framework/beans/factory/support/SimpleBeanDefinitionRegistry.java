package com.mam.framework.beans.factory.support;

import com.mam.framework.beans.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * 注册表子接口实现类
 **/
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry{

    //定义一个容器，用来存储BeanDefinition对象
    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanDefinitionMap.remove(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
