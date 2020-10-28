package com.nbteam.hislite.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Map工具类
 */
public class MapTool {
    private static final Logger logger = LoggerFactory.getLogger(MapTool.class);

    /**
     * get a HashMap<keyType,valueType>
     * 
     * @param keyType
     * @param valueType
     * @param params
     * @return
     */
    public static <K, V> Map<K, V> getMap(Class<K> keyType, Class<V> valueType, Object... params) {
        Map<K, V> map = new HashMap<K, V>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put(keyType.cast(params[2 * n]), valueType.cast(params[2 * n + 1]));
        }
        return map;
    }

    /**
     * get a HashMap<String,Object>
     * 
     * @param params
     * @return
     */
    public static Map<String, Object> getSOMap(Object... params) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put(String.class.cast(params[2 * n]), params[2 * n + 1]);
        }
        return map;
    }

    /**
     * get a HashMap<String,String>
     * 
     * @param params
     * @return
     */
    public static Map<String, String> getSSMap(Object... params) {
        Map<String, String> map = new HashMap<String, String>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put((String) (params[2 * n]), (String) params[2 * n + 1]);
        }
        return map;
    }

    /**
     * 将入参拼接成放入一个LinkedMap<keyType,valueType>中，奇数位参数为key，偶数位为值
     * 
     * @param params
     * @return
     */
    public static <K, V> Map<K, V> getLinkedMap(Class<K> keyType, Class<V> valueType, Object... params) {
        Map<K, V> result = new LinkedHashMap<K, V>();
        if (params == null) {
            return result;
        }
        for (int n = 0; n < params.length / 2; n++) {
            result.put(keyType.cast(params[2 * n]), valueType.cast(params[2 * n + 1]));
        }
        return result;
    }

    /** 
     * 将一个数组对象转换成一个Map，对象必须是javaBean，不能是map
     * @param keyType
     * @param keyName
     * @param valueType
     * @param valueName
     * @param list
     * @return
     * @throws RuntimeException
     */ 
    public static <K, V> Map<K, V> listObjToMap(List<?> list,Class<?> dataType,
            Class<K> keyType, String keyName, Class<V> valueType, String valueName)
            throws RuntimeException {
        Map<K, V> resultMap = new HashMap<>();
        if(list==null || list.size()==0) {
            return resultMap;
        }
        try {
            Field keyF = ReflectTool.getField(dataType, keyName);
            Field valueF = ReflectTool.getField(dataType, valueName);
            for(Object obj : list) {
                resultMap.put(keyType.cast(keyF.get(obj)), valueType.cast(valueF.get(obj)));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
        return resultMap;
    }
    
    /** 
     * 将一个数组对象转换成一个Map，对象必须是javaBean，对象是map
     * @param keyType
     * @param keyName
     * @param valueType
     * @param valueName
     * @param list
     * @return
     * @throws RuntimeException
     */ 
    public static <K, V> Map<K, V> listMapToMap(List<Map<?,?>> list,
            Class<K> keyType, String keyName, Class<V> valueType, String valueName)
                    throws RuntimeException {
        Map<K, V> resultMap = new HashMap<>();
        if(list==null || list.size()==0) {
            return resultMap;
        }
        try {
            for(Map<?,?> obj : list) {
                resultMap.put(keyType.cast(obj.get(keyName)), valueType.cast(obj.get(valueName)));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
        return resultMap;
    }

    //将javabean实体类转为map类型，然后返回一个map类型的值
    public static Map<String, Object> beanToMap(Object obj) {
        if(obj == null){
            return null;
        }
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
 /*   
    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(new TreeNode(1, 1, "node1"));
        list.add(new TreeNode(2, 2, "node2"));
        System.out.println(listObjToMap(list, TreeNode.class,Integer.class, "id", String.class, "name"));
        List<Map<?,?>> list1 = new ArrayList<>();
        list1.add(getSOMap("id",1,"name","node1"));
        list1.add(getSOMap("id",2,"name","node2"));
        System.out.println(listMapToMap(list1, Integer.class, "id", String.class, "name"));
    }*/
}