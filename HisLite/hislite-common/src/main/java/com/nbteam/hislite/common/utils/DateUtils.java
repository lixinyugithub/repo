package com.nbteam.hislite.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Description: 时间处理<br/>
 *
 */
public class DateUtils {

    private static final String SIMPlE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String SIMPLE_SHORT_FORMAT = "yyyy-MM-dd";

    private static final String[] WEEK_DAYS = new String[] { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };

    public static String getHourMin(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
        return fmt.format(date);
    }

    /**
     * 
     * 获取n天后的时间. <br/>
     * 
     * @version 1.0
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDate(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        return c.getTime();
    }

    public static String getSimpleShortDate(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(SIMPLE_SHORT_FORMAT).format(date);

    }

    /**
     * 
     * 字符串转时间. <br/>
     * 
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static Date parseSimpeDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return new SimpleDateFormat(SIMPlE_FORMAT).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFormatPayDate(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }

    /**
     * 
     * 获取指定日期是星期几. <br/>
     * 
     * @version 1.0
     *
     * @param date
     * @return
     */
    public static String getWeekName(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int num = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (num < 0) {
            num = 0;
        }
        return WEEK_DAYS[num];
    }

    /**
     *
     * @Title: getDaysInterval
     * @Description: 获取日期间隔
     * @param startDate
     * @param endDate
     * @return Long
     * @throws
     */
    public static Long getDaysInterval(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime()) / 86400000;
    }

    /**
     *
     * @Title: getSecondsInterval
     * @Description: 获取秒间隔
     * @param startDate
     * @param endDate
     * @return Long
     * @throws
     */
    public static Long getSecondsInterval(Date startDate, Date endDate) {
        return ((endDate.getTime() - startDate.getTime()) / 1000);
    }

    /**
     *
     * @Title: getMinutesInterval
     * @Description: 获取分钟间隔
     * @param startDate
     * @param endDate
     * @return Long
     * @throws
     */
    public static Long getMinutesInterval(Date startDate, Date endDate) {
        return ((endDate.getTime() - startDate.getTime()) / 1000/ 60);
    }
}
