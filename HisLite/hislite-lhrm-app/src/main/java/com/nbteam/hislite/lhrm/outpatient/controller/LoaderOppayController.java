package com.nbteam.hislite.lhrm.outpatient.controller;

import com.nbteam.hislite.frame.controller.BaseController;
import com.nbteam.hislite.lhrm.api.outpatient.vo.CreateOppayOrderResultVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.OppayOrdersParamVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.HisOppayOrderVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.Oppayed2HisResultVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.QryOppayOrderStatusResultVo;
import com.nbteam.hislite.lhrm.outpatient.service.LoaderOppayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value="门诊缴费订单接口",tags = {"门诊缴费订单接口"})
@RestController
@RequestMapping
public class LoaderOppayController extends BaseController {
    
    public static final Logger logger = LoggerFactory.getLogger(LoaderOppayController.class);

    @Autowired
    private LoaderOppayService loaderOppayService;

    /**
     *
     * 获取远程医院门诊待支付订单信息列表. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取远程医院门诊待支付订单信息列表")
    public List<HisOppayOrderVo> getHisOppayOrders(@RequestBody @ApiParam("参数{\"patCardNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.getHisOppayOrders(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 门诊缴费信息检查. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "门诊缴费信息检查")
    public HisOppayOrderVo checkOppayOrder(@RequestBody @ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"hisOrderNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.checkOppayOrder(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 发送门诊支付订单到医院. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "发送门诊支付订单到医院")
    public Oppayed2HisResultVo getHisOppayResult(@RequestBody @ApiParam("参数{\"prescriptionNo\":\"\",\"patientName\":\"\",\"patCardNo\":\"\",\"updateDate\":\"\",\"orderFee\":\"\",\"feeType\":\"\",\"tradeNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.getHisOppayResult(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 睿博医院支付下单. <br/>(参数:totAmt-金额,patHisNo批次号,patCardNo-卡号,patientName-姓名,dataSrc-缴费类型(门诊缴费:hisSrc;住院预缴:prepaySrc;挂号缴费:register;预约缴费:subscription),hisOrderNo-医院订单号,payType-支付渠道(微信扫码支付：wechatQrcode,支付宝扫码支付：alipayQrcode))
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "睿博医院支付下单")
    public CreateOppayOrderResultVo createOppayOrder(@RequestBody @ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"hisOrderNo\":\"\",\"totAmt\":\"\",\"patHisNo\":\"\",\"dataSrc\":\"\",\"payType\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.createOppayOrder(params.getHisId(), params.getExtProps());
    }
    
    /**
    *
    * 睿博医院支付查询. <br/>(参数:hospitalId-医院id,tradeNo订单号 ))
    *
    * @return
    */
   @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   @ApiOperation(value = "睿博医院支付查询")
   public QryOppayOrderStatusResultVo qryOppayOrderStatus(@RequestBody @ApiParam("参数{\" tradeNo \":\"\"}") OppayOrdersParamVo params) {
       return loaderOppayService.qryOppayOrderStatus(params.getHisId(), params.getExtProps());
   }



    /**
     *
     * 获取远程医院门诊待支付订单信息列表. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取远程医院门诊待支付订单信息列表")
    public List<HisOppayOrderVo> getHisOppayOrdersMock(@RequestBody @ApiParam("参数{\"patCardNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.getHisOppayOrdersMock(params.getHisId(), params.getExtProps());
    }


    /**
     *
     * 模拟门诊缴费信息检查. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "门诊缴费信息检查")
    public HisOppayOrderVo checkOppayOrderMock(@RequestBody @ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"hisOrderNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.checkOppayOrderMock(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 睿博医院支付下单. <br/>(参数:totAmt-金额,patHisNo批次号,patCardNo-卡号,patientName-姓名,dataSrc-缴费类型(门诊缴费:hisSrc;住院预缴:prepaySrc;挂号缴费:register;预约缴费:subscription),hisOrderNo-医院订单号,payType-支付渠道(微信扫码支付：wechatQrcode,支付宝扫码支付：alipayQrcode))
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "睿博医院支付下单")
    public CreateOppayOrderResultVo createOppayOrderMock(@RequestBody @ApiParam("参数{\"patientName\":\"\",\"patCardNo\":\"\",\"hisOrderNo\":\"\",\"totAmt\":\"\",\"patHisNo\":\"\",\"dataSrc\":\"\",\"payType\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.createOppayOrderMock(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 发送门诊支付订单到医院. <br/>
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "发送门诊支付订单到医院")
    public Oppayed2HisResultVo getHisOppayResultMock(@RequestBody @ApiParam("参数{\"prescriptionNo\":\"\",\"patientName\":\"\",\"patCardNo\":\"\",\"updateDate\":\"\",\"orderFee\":\"\",\"feeType\":\"\",\"tradeNo\":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.getHisOppayResultMock(params.getHisId(), params.getExtProps());
    }

    /**
     *
     * 睿博医院支付查询. <br/>(参数:hospitalId-医院id,tradeNo订单号 ))
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "睿博医院支付查询")
    public QryOppayOrderStatusResultVo qryOppayOrderStatusMock(@RequestBody @ApiParam("参数{\"tradeNo \":\"\"}") OppayOrdersParamVo params) {
        return loaderOppayService.qryOppayOrderStatusMock(params.getHisId(), params.getExtProps());
    }
}
