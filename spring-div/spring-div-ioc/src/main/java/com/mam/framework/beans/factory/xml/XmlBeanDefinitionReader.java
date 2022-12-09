package com.mam.framework.beans.factory.xml;

import com.mam.framework.beans.BeanDefinition;
import com.mam.framework.beans.MutablePropertyValue;
import com.mam.framework.beans.PropertyValue;
import com.mam.framework.beans.factory.support.BeanDefinitionReader;
import com.mam.framework.beans.factory.support.BeanDefinitionRegistry;
import com.mam.framework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2022/12/09
 * 针对xml配置文件进行解析的类
 **/
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    //声明注册表对象
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(){
        registry = new SimpleBeanDefinitionRegistry();
    }
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        //使用dom4j进行xml配置文件的解析
        SAXReader saxReader = new SAXReader();
        //获取类路径下的配置文件
        InputStream resource = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = saxReader.read(resource);
        //根据document对象获取根标签对象
        Element rootElement = document.getRootElement();
        List<Element> beanElements = rootElement.elements("bean");
        for (Element beanElement : beanElements) {
            String id = beanElement.attributeValue("id");
            String className = beanElement.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            MutablePropertyValue mutablePropertyValue = new MutablePropertyValue();
            //获取bean标签下所有的property标签对象
            List<Element> elements = beanElement.elements("property");
            for (Element element : elements) {
                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");
                String value = element.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValue.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValue(mutablePropertyValue);
            //将beanDefinition注册到注册表中
            registry.registerBeanDefinition(id,beanDefinition);
        }
    }
}
