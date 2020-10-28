package com.nbteam.hislite.payment.pay.utils;

import java.lang.annotation.*;

/***
 *
 * <pre>描述: 任务执行注解</pre>
 * <pre>日期: 2017年11月28日 下午5:22:00</pre>
 * @author chenxin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PayServiceHandler {
    String name();
    
}
