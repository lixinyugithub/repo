package com.nbteam.hislite.frame.exception;

import com.nbteam.hislite.common.exception.BizException;
import com.nbteam.hislite.common.exception.BusinessException;
import com.nbteam.hislite.common.vo.BaseResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 统一异常处理接口
 */
@ControllerAdvice
public class WebException {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(WebException.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResultVo exeMethodArgEcp(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        String errorMsgStr = "";
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        if (errors != null && errors.size() > 0) {
            errorMsgStr = errors.get(0).getDefaultMessage();
        } else {
            errorMsgStr = "糟糕，你输入了火星上的文字";
        }
        BaseResultVo baseResp = new BaseResultVo();
        baseResp.setResultCode(BusinessException.PRARM_ERROR + "");
        baseResp.setResultMsg(errorMsgStr);
        return baseResp;
    }

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public BaseResultVo exeMethodArgEcp(BizException exception) {
        exception.printStackTrace();
        BaseResultVo baseResp = new BaseResultVo();
        baseResp.setResultCode(exception.getCode() + "");
        baseResp.setResultMsg(exception.getMsg());
        return baseResp;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResultVo execp(Exception exception) {
        exception.printStackTrace();
        logger.error("发生异常:" + exception.getLocalizedMessage());
        BaseResultVo baseResp = new BaseResultVo();
        baseResp.setResultCode(BusinessException.UNKNOW_ERROR + "");
        baseResp.setResultMsg("服务器开了点小差，攻城狮正在把他叫醒");
        return baseResp;
    }
}
