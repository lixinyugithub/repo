package com.nbteam.hislite.his.outpatient.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.his.api.outpatient.vo.PreOppayParamsVo;
import com.nbteam.hislite.his.api.outpatient.vo.WaitPayOrderVo;
import com.nbteam.hislite.his.outpatient.service.PreOppayOrderService;
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
import java.util.List;

@Api(value="门诊缴费订单接口",tags = {"门诊缴费订单接口"})
@RestController
@RequestMapping
public class PreOppayOrderController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(PreOppayOrderController.class);

    @Autowired
    private PreOppayOrderService preOppayOrderService;

    /**
     *
     * 获取待付款列表. <br/>
     *
     *
     * @param params
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "获取待付款列表")
    public List<WaitPayOrderVo> getWaitPayOrders(@RequestBody @ApiParam("订单参数") @Valid PreOppayParamsVo params) {
        return preOppayOrderService.getWaitPayOrders(params);
    }

}
