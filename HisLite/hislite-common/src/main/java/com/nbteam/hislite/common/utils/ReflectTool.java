package com.nbteam.hislite.common.utils;


import com.nbteam.hislite.common.exception.BizException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * java 反射工具类
 */
public class ReflectTool {
    
    /** 
     * 获取某个类的某个字段 支持查找父类，并且打开访问权限
     * @author liuzhongqi 
     * @date: 2016年12月16日 上午11:16:34
     * @version 1.0
     *
     * @param cls
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     */ 
    public static Field getField(Class<?> cls, String fieldName) throws NoSuchFieldException{
        Field f = null;
        Class<?> clazz = cls;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            } catch (Exception e) {
            }
        }
        throw new NoSuchFieldException("类"+cls.getName()+"找不到属性"+fieldName);
    }
    
    private Boolean isMap = false; 
    private Map<String, Field> fields = null;
    
    public ReflectTool(Object o,List<String> fieldNames) throws NoSuchFieldException {
        if(o instanceof Map) {
            isMap = true;
        }else{
            fields = new HashMap<>(fieldNames.size());
            Field f;
            Class<?> cls = o.getClass();
            for(Object fieldName : fieldNames) {
                f=null;
                for (Class<?> clazz = cls; clazz != Object.class; clazz = clazz.getSuperclass()) {
                    try {
                        f = clazz.getDeclaredField(fieldName.toString());
                        f.setAccessible(true);
                        break;
                    } catch (Exception e) {
                    }
                }
                if(f==null) {
                    throw new NoSuchFieldException("类"+cls.getName()+"找不到属性"+fieldName);
                }
                fields.put(fieldName.toString(), f);
            }
        }
    }
    
    public Object get(Object o, String fieldName) {
        if(isMap) {
            return ((Map<?,?>)o).get(fieldName);
        }else {
            try {
                return fields.get(fieldName).get(o);
            }catch (Exception e) {
                throw new BizException(BizException.DEFAULT_CODE,e.getMessage());
            }
        }
    }
}