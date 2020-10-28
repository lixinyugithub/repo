package com.nbteam.hislite.payment.pay.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.payment.pay.service.AsyncProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Map;

@Api(value="支付结果处理",tags = {"支付结果处理"})
@RestController
@RequestMapping
public class AsyncProcessController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(AsyncProcessController.class);
    
    @Autowired
    private AsyncProcessService asyncProcessService;

    /**
     *
     * 微信支付结果回传接口. 在业务处理失败支付成功的情况下，需要抛出异常将MQ消息重发<br/>
     *
     * @param payResultXML
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "微信支付结果回传接口")
    public Boolean asyncWeixinPayResult(@RequestBody @Valid @ApiParam("微信支付结果回传参数") String payResultXML) {
        return asyncProcessService.asyncWeixinPayResult(payResultXML);
    }

    /**
     *
     * 支付宝支付回掉接口
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "支付宝支付回掉接口")
    public Boolean asyncAlipayResult(@RequestBody @Valid @ApiParam("支付宝支付回掉参数") Map<String, String> paramsMap) {
        return asyncProcessService.asyncAlipayResult(paramsMap);
    }

    /**
     *
     * 微信医保支付回调接口. <br/>
     *
     * @return 返回签名后的xml
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "登记支付订单")
    public String asyncWeixinMedPayResult(@RequestBody @Valid @ApiParam("登记支付单参数") String payResultXML) {
        return null;
    }

    /**
     *
     * 初始化缓存配置. <br/>
     *
     * @param ipAddress
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "初始化缓存配置")
    public void initCache(String ipAddress) {

    }

    /**
     *
     * 重复发送支付结果到业务. <br/>
     *
     * @param payOrderId
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "重复发送支付结果到业务")
    public void sendSuccessOrder(@RequestBody @Valid @ApiParam("发送支付结果参数") Long payOrderId) {
        asyncProcessService.sendSuccessOrder(payOrderId);
    }
}
