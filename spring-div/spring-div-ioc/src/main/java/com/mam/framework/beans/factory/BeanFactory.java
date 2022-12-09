package com.mam.framework.beans.factory;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * IOC容器父接口
 **/
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    <T>T getBean(String name,Class<? extends T> clazz) throws Exception;
}
