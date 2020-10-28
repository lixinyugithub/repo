package com.nbteam.hislite.lhrm.inhospital.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.lhrm.api.inhospital.vo.HisPatientExpenseVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InHosputalHisResultVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InhospitalOrdersParamVo;
import com.nbteam.hislite.lhrm.inhospital.service.InHospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value="住院费用接口",tags = {"住院费用接口"})
@RestController
@RequestMapping
public class InHospitalController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(InHospitalController.class);

    @Autowired
    private InHospitalService inHospitalService;

    /**
     *
     * 获取远程医院门诊待支付订单信息列表. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "获取就诊人已预缴的住院费用表")
    public HisPatientExpenseVo getPatientExpense(@ApiParam("参数{\"patCardNo\":\"\"}") @RequestBody InhospitalOrdersParamVo params) {
        return inHospitalService.getPatientExpense(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 门诊缴费信息检查. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "预缴住院费用")
    public InHosputalHisResultVo prePayExpense(@ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"prepayAmt\":\"\",\"tradeNo\":\"\"}")
                                                   @RequestBody InhospitalOrdersParamVo params) {
        return inHospitalService.prePayExpense(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 获取远程医院门诊待支付订单信息列表. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "获取就诊人已预缴的住院费用表")
    public HisPatientExpenseVo getPatientExpenseMock(@ApiParam("参数{\"patCardNo\":\"\"}") @RequestBody InhospitalOrdersParamVo params) {
        return inHospitalService.getPatientExpenseMock(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 门诊缴费信息检查. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "预缴住院费用")
    public InHosputalHisResultVo prePayExpenseMock(@ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"prepayAmt\":\"\",\"tradeNo\":\"\"}")
                                               @RequestBody InhospitalOrdersParamVo params) {
        return inHospitalService.prePayExpenseMock(params.getHisId(), params.getExtProps());
    }

}
