package com.nbteam.hislite.his.outpatient.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import com.nbteam.hislite.his.api.outpatient.vo.OppayParamsVo;
import com.nbteam.hislite.his.api.outpatient.vo.PayOrderCreateResultVo;
import com.nbteam.hislite.his.api.outpatient.vo.PayOrderParamVo;
import com.nbteam.hislite.his.api.outpatient.vo.PayResultVo;
import com.nbteam.hislite.his.outpatient.service.OppayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value="门诊缴费订单接口",tags = {"门诊缴费订单接口"})
@RestController
@RequestMapping
public class OppayOrderController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(OppayOrderController.class);

    @Autowired
    private OppayOrderService oppayOrderService;

    /**
     *
     * 创建门诊订单. <br/>
     *
     * @param params
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "创建门诊订单")
    public HisOppayOrder generatorOppayOrder(@RequestBody @ApiParam("订单参数") OppayParamsVo params) {
        return oppayOrderService.generatorOppayOrder(params);
    }

    /**
     *
     * 门诊业务支付下单. <br/>
     *
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "门诊业务支付下单")
    public PayOrderCreateResultVo registerPayOrder(@RequestBody @ApiParam("订单参数") PayOrderParamVo orderParamVo) {
        return oppayOrderService.registerPayOrder(orderParamVo);
    }

    /**
     *
     * 重新通知医院. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "重新通知医院")
    public Boolean notifyExternal(@RequestParam @ApiParam("订单编号") Long orderId, @RequestParam @ApiParam("订单类型")String orderType) {
        return oppayOrderService.notifyExternal(orderId, orderType);
    }

    /**
     *
     * 订单支付回调接口. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "订单支付回调接口")
    public Boolean payResult(@RequestBody @Valid @ApiParam("支付结果") PayResultVo payResultVo) {
        return oppayOrderService.payResult(payResultVo);
    }

    /**
     *
     * 是否可以继续支付. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "是否可以继续支付")
    public Boolean canPay(@RequestParam @ApiParam("订单编号") Long orderId,
            @RequestParam @ApiParam("订单类型") String orderType, @RequestParam @ApiParam("总费用") Integer totalFee) {
        return oppayOrderService.canPay(orderId, orderType, totalFee);
    }

    /**
     *
     * 获取订单. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "获取订单")
    public HisOppayOrder getOppayOrder(@RequestParam @ApiParam("订单编号") Long orderId, @RequestParam @ApiParam("医院订单编号") String tradeNo) {
        return oppayOrderService.getOppayOrder(orderId, tradeNo);
    }
}
