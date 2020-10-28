package com.nbteam.hislite.his.outpatient.controller;

import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import com.nbteam.hislite.his.api.outpatient.vo.OutpatientPayParamVo;
import com.nbteam.hislite.his.api.outpatient.vo.OutpatientPayResultVo;
import com.nbteam.hislite.his.api.outpatient.vo.PayResultVo;
import com.nbteam.hislite.his.outpatient.service.OppayOrderService;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OutpatientEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(OutpatientEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.easyhos.com/webservice";


    @Autowired
    private OppayOrderService oppayOrderService;

    @Autowired
    public OutpatientEndpoint(OppayOrderService oppayOrderService) {
        this.oppayOrderService = oppayOrderService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "outpatientPay")
    @ResponsePayload
    public OutpatientPayResultVo outpatientPay(@RequestPayload OutpatientPayParamVo request) {
        LOG.info("门诊缴费支付通知接口入参参数：request={}", request);
        OutpatientPayResultVo response = new OutpatientPayResultVo();
        HisOppayOrder order = oppayOrderService.getOppayOrderByHisOrderNo(request.getTradeNo());
        if (order == null) {
            response.setResult(HosConstants.RETURN_CODE_FAIL);
            response.setMessage("没有找到对应的订单");
            return response;
        }
        PayResultVo payResultVo = new PayResultVo();
        payResultVo.setCode("0");
        payResultVo.setOrderId(order.getOppayOrderId());
        boolean result = oppayOrderService.payResult(payResultVo);

        if (result) {
            response.setResult(HosConstants.RETURN_CODE_SUCCESS);
            response.setMessage("模拟成功返回");
            response.setInvoiceNo("发票号");
            response.setSerialNo("his 流水号");
        }
        else {
            response.setResult(HosConstants.RETURN_CODE_FAIL);
            response.setMessage("模拟失败返回");
        }
        return response;
    }
}
