package com.nbteam.hislite.common.utils;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.trim;

/**
 * 参数转换工具类
 * 
 * @author 刘忠奇
 *
 */
public class ParamTool {

    /**
     * String转Integer，为空时返回null，整形转换异常直接抛出
     * 
     * @param param
     * @return
     */
    public static Integer getInt(String param) throws Exception {
        if (param == null || isBlank(param)) {
            return null;
        }
        try {
            return Integer.parseInt(trim(param));
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * String转Long，为空时返回null，整形转换异常直接抛出
     * 
     * @param param
     * @return
     */
    public static Long getLong(String param) throws Exception {
        if (param == null || isBlank(param)) {
            return null;
        }
        try {
            return Long.parseLong(trim(param));
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 
     * 处理空字符串的问题. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年12月4日 下午10:54:05
     * @version 1.0
     *
     * @param obj
     * @return
     */
    public static String getStringValue(Object obj) {
        if (obj == null) {
            return "";
        }
        return String.valueOf(obj);
    }
}
