package com.mam.pattern.factory.config_factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * @Author Anmin
 * @Date 2022/12/05
 **/
public class CoffeeFactory {

    //加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    private static HashMap<String,Coffee> map = new HashMap<>();
    //加载配置文件，只加载一次
    static {
        Properties properties = new Properties();
        InputStream stream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(stream);
            Set<Object> keySet = properties.keySet();
            for(Object key : keySet){
                String className = properties.getProperty((String) key);
                Class nameClass =  Class.forName(className);
                Coffee coffee = (Coffee)nameClass.newInstance();
                map.put((String)key,coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据名称获取对象
    public static Coffee createCoffee(String key){
        return map.get(key);
    }
}
