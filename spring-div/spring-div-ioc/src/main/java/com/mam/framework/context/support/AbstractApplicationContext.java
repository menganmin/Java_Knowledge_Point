package com.mam.framework.context.support;

import com.mam.framework.beans.BeanDefinition;
import com.mam.framework.beans.factory.support.BeanDefinitionReader;
import com.mam.framework.beans.factory.support.BeanDefinitionRegistry;
import com.mam.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * ApplicationContext接口的子实现类，用于立刻加载
 **/
public abstract class AbstractApplicationContext implements ApplicationContext {

    //声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;

    //定义用于存储bean对象的map容器
    protected Map<String,Object> singleton = new HashMap<>();

    //声明配置文件路径的变量
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        finishBeanInitialization();
    }

    private void finishBeanInitialization() throws Exception{
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        //获取BeanDefinition对象
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            //进行bean的初始化
            getBean(definitionName);
        }
    }
}
