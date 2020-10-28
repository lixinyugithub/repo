package com.nbteam.hislite.payment.pay.utils;

import com.nbteam.hislite.payment.pay.service.IPayServiceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 *
 */
@Component
public class PayServiceExecutor implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(PayServiceExecutor.class);

    public static ConcurrentHashMap<String, IPayServiceHandler> handlerTreadMap = new ConcurrentHashMap<String, IPayServiceHandler>();

    // ---------------------------------- init job handler ------------------------------------
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PayServiceExecutor.applicationContext = applicationContext;
        initPayServiceHandler();
    }

    public void initPayServiceHandler(){
        Map<String, Object> serviceBeanMap = PayServiceExecutor.applicationContext.getBeansWithAnnotation(PayServiceHandler.class);
        if (serviceBeanMap!=null && serviceBeanMap.size()>0) {
            for (Object serviceBean : serviceBeanMap.values()) {
                String payServiceHandlerName = serviceBean.getClass().getAnnotation(PayServiceHandler.class).name();
                if (payServiceHandlerName!=null && payServiceHandlerName.trim().length()>0 && serviceBean instanceof IPayServiceHandler) {
                    IPayServiceHandler handler = (IPayServiceHandler) serviceBean;
                    handlerTreadMap.put(payServiceHandlerName, handler);
                }
            }
        }
    }
}
