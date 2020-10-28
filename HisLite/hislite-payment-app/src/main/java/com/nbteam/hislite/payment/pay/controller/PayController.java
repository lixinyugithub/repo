package com.nbteam.hislite.payment.pay.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.payment.api.pay.vo.*;
import com.nbteam.hislite.payment.pay.service.PaymentOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value="支付管理",tags = {"支付管理"})
@RestController
@RequestMapping
public class PayController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(PayController.class);
    
    @Autowired
    private PaymentOrderService paymentOrderService;

    /**
     * 登记支付订单
     * @param vo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "登记支付订单")
    public UnifiedOrderResultVo registerPayOrder(@RequestBody @Valid @ApiParam("登记支付单参数") UnifiedOrderParamVo vo) {
        return paymentOrderService.registerPayOrder(vo);
    }

    /**
     * 扫码支付统一下单接口
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "扫码支付统一下单接口")
    public UnifiedOrderResultVo qrPayUnifiedOrder(@RequestBody @Valid @ApiParam("登记支付单参数") UnifiedOrderParamVo vo) {
        return paymentOrderService.qrPayUnifiedOrder(vo);
    }

    /**
     * 选择支付方式，请求微信支付或统一下单
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "选择支付方式")
    public ChooseModeResultVo chooseMode(ChooseModeParamVo param) {
        return paymentOrderService.chooseMode(param);
    }

    /**
     * 当面付提交
     * @param vo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "当面付提交")
    public F2FPayResultVo f2fPayOrder(F2FPayParamVo vo) {
        //TODO
        return null;
    }



    /**
     * 查询支付方式
     * @param payOrderId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "查询支付方式")
    public QueryModeResultVo queryMode(Long payOrderId) {
        //TODO
        return null;
    }

    /**
     * 通用订单状态查询
     * @param vo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "通用订单状态查询")
    public PayQueryResultVo payOrderQuery(PayQueryParamVo vo) {
        //TODO
        return null;
    }

    /**
     * 撤销订单API
     * @param vo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "撤销订单API")
    public F2FRevokeResultVo f2FPayRevoke(F2FPayRevokeParamVo vo) {
        //TODO
        return null;
    }

    /**
     * 支付关闭
     * @param vo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "支付关闭")
    public ClosePayOrderResultVo closePayOrder(ClosePayOrderParamVo vo) {
        //TODO
        return null;
    }

    /**
     * 批量关闭支付订单
     * @param ids
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "批量关闭支付订单")
    public Integer closePayOrders(List<Long> ids) {
        //TODO
        return null;
    }

    /**
     * 根据业务订单号获取支付订单信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "根据业务订单号获取支付订单信息")
    public PayOrderInfoVo getPayOrderInfoByBizOrderId(Long bizOrderId) {
        //TODO
        return null;
    }

    /**
     * 根据流水号查询支付订单信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "根据流水号查询支付订单信息")
    public PayOrderInfoVo getPayOrderInfoByAcquirerSerialNo(String acquirerSerialNo) {
        //TODO
        return null;
    }



    /**
     * 获取待关闭订单id列表
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "获取待关闭订单id列表")
    public List<Long> getWaitCloseOrderIds(Long currentId) {
        //TODO
        return null;
    }

    /**
     * 根据merchantOrderid获取订单信息
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "根据merchantOrderid获取订单信息")
    public PayOrderInfoVo getPayOrderInfoByMerchantOrderId(String merchantOrderId) {
        //TODO
        return null;
    }
}
