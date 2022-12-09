package com.mam.framework.context;


import com.mam.framework.beans.factory.BeanFactory;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * 定义非延时加载功能
 **/
public interface ApplicationContext extends BeanFactory {

    void refresh() throws Exception;
}
