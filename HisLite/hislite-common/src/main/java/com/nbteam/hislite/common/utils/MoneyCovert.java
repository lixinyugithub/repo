package com.nbteam.hislite.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Description: 金额转换<br/>
 *
 */
public class MoneyCovert {
    /**
     * 
     * 返回元. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年10月26日 下午5:09:44
     * @version 1.0
     *
     * @param money
     * @return
     */
    public static String formatMoney(BigDecimal money) {
        if (money == null) {
            money = BigDecimal.ZERO;
        }
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(money.doubleValue());
    }

    /**
     * 
     * 分转元. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年10月26日 下午5:10:00
     * @version 1.0
     *
     * @param money
     * @return
     */
    public static String formatToYuan(Integer money) {
        if (money == null) {
            return "0.00";
        }
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(BigDecimal.valueOf(money).divide(BigDecimal.valueOf(100)).doubleValue());
    }

    /**
     * 返回分单位
     * 
     * @param money
     * @return
     */
    public static int covertFenMoney(String money) {
        if (StringUtils.isBlank(money)) {
            return 0;
        }
        BigDecimal amount = BigDecimal.valueOf(Double.valueOf(money));
        return covertFenMoney(amount);
    }

    /**
     * 
     * 数学方式处理fen，可以包括负数. <br/>
     * 
     * @author liujingcheng
     * @date: 2017年4月19日 上午11:10:58
     * @version 1.0
     *
     * @param money
     * @return
     */
    public static int coverMathFen(String money) {
        if (StringUtils.isBlank(money)) {
            return 0;
        }
        BigDecimal amount = BigDecimal.valueOf(Double.valueOf(money));
        return amount.multiply(BigDecimal.valueOf(100)).intValue();
    }

    /**
     * 返回分单位
     * 
     * @param money
     * @return
     */
    public static int covertFenMoney(BigDecimal money) {
        if (money == null || money.compareTo(BigDecimal.ZERO) <= 0) {
            return 0;
        } else {
            return money.multiply(BigDecimal.valueOf(100)).intValue();
        }
    }
}
