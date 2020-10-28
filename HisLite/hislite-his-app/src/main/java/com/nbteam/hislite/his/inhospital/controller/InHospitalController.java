package com.nbteam.hislite.his.inhospital.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.his.api.inhospital.vo.CreatePayOrderResultVo;
import com.nbteam.hislite.his.api.inhospital.vo.InHospitalOrderVo;
import com.nbteam.hislite.his.api.inhospital.vo.InHospitalParamsVo;
import com.nbteam.hislite.his.api.inhospital.vo.InHospitalVo;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import com.nbteam.hislite.his.api.outpatient.vo.*;
import com.nbteam.hislite.his.inhospital.service.InHospitalService;
import com.nbteam.hislite.his.outpatient.service.OppayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value="住院缴费订单接口",tags = {"住院缴费订单接口"})
@RestController
@RequestMapping
public class InHospitalController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(InHospitalController.class);

    @Autowired
    private InHospitalService inHospitalService;

    /**
     *
     * 通过住院号查询最新住院信息. <br/>
     *
     *
     * @param serialNumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "通过住院号查询最新住院信息")
    public InHospitalVo getRecentInHospital(@RequestParam @ApiParam("医院编号") Long hisId,
                                            @RequestParam @ApiParam("住院号") String serialNumber) {
        return inHospitalService.getRecentInHospital(hisId, serialNumber);
    }

    /**
     *
     * 创建住院订单. <br/>
     *
     * @param params
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "创建住院订单")
    public InHospitalOrderVo generatorInHospitalOrder(@RequestBody @Valid @ApiParam("订单参数") InHospitalParamsVo params) {
        return inHospitalService.generatorInHospitalOrder(params);
    }

    /**
     *
     * 住院业务支付下单. <br/>
     *
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "住院业务支付下单")
    public CreatePayOrderResultVo registerPayOrder(@RequestBody @Valid @ApiParam("订单参数") InHospitalOrderVo order) {
        return inHospitalService.registerPayOrder(order);
    }

    /**
     *
     * 发送通知医院. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "发送通知医院")
    public Boolean orderPayJudge(@RequestParam @ApiParam("订单编号") Long orderId, @RequestParam @ApiParam("订单类型")String orderType) {
        return inHospitalService.orderPayJudge(orderId);
    }
}
