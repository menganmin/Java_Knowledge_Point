package com.mam.framework.utils;

/**
 * @Author Anmin
 * @Date 2022/12/09
 **/
public class StringUtils {
    private StringUtils(){}

    public static String getSetterMethodByFieldName(String fieldName){
        return "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }
}
