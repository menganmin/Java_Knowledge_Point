package com.mam.framework.context.support;

import com.mam.framework.beans.BeanDefinition;
import com.mam.framework.beans.MutablePropertyValue;
import com.mam.framework.beans.PropertyValue;
import com.mam.framework.beans.factory.support.BeanDefinitionRegistry;
import com.mam.framework.beans.factory.xml.XmlBeanDefinitionReader;
import com.mam.framework.utils.StringUtils;

import java.lang.reflect.Method;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * IOC容器具体子实现类
 * 用于加载类路径下的xml格式的配置文件
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    public ClassPathXmlApplicationContext(String configLocation){
        this.configLocation = configLocation;
        //构件解析器对象
        beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            refresh();
        }catch (Exception e){

        }
    }

    //根据bean对象名称获取bean对象
    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singleton.get(name);
        if(obj != null){
            return obj;
        }
        //获取BeanDefinition对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        String className = beanDefinition.getClassName();
        //通过反射创建对象
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.newInstance();

        //进行依赖注入
        MutablePropertyValue mutablePropertyValue = beanDefinition.getPropertyValue();
        for (PropertyValue propertyValue : mutablePropertyValue) {
            String propertyValueName = propertyValue.getName();
            String ref = propertyValue.getRef();
            String value = propertyValue.getValue();
            if(ref != null && !"".equals(ref)){
                //获取依赖的bean对象
                Object bean = getBean(ref);
                //拼接方法名
                String methodName = StringUtils.getSetterMethodByFieldName(propertyValueName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if(methodName.equals(method.getName())){
                        method.invoke(instance,bean);
                    }
                }
            }
            if(value != null && !"".equals(value)){
                String methodName = StringUtils.getSetterMethodByFieldName(propertyValueName);
                //获取method对象
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(instance,value);
            }
        }
        //再返回之前，将该对象存放到容器中
        singleton.put(name,instance);
        return instance;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object obj = getBean(name);
        if(obj == null){
            return null;
        }
        return clazz.cast(obj);
    }
}
