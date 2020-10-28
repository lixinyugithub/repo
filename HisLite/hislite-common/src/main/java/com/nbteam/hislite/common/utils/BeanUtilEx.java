package com.nbteam.hislite.common.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BeanUtilEx extends BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtilEx.class);

    private BeanUtilEx() {
    }

    static {
        ConvertUtils.register(new SqlDateConverter(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
    }

    public static void copyProperties(Object target, Object source) {
        try {
            BeanUtils.copyProperties(target, source);
        } catch (Exception e) {
            logger.error("对象转化异常 target:{},source:{} ,exception:{}", target.getClass().toString(), source.getClass().toString(),
                    e.getLocalizedMessage());
        }

    }
}