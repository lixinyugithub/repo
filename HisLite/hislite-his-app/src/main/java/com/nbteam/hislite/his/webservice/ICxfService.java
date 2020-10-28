package com.nbteam.hislite.his.webservice;

import com.nbteam.hislite.his.api.outpatient.vo.OutpatientPayParamVo;
import com.nbteam.hislite.his.api.outpatient.vo.OutpatientPayResultVo;
import org.springframework.http.MediaType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface ICxfService {


    @WebMethod
    // @WebResult(name = "outpatientPay", targetNamespace = "http://hislite.nbteam.com/")
    OutpatientPayResultVo outpatientPay(OutpatientPayParamVo request);

}