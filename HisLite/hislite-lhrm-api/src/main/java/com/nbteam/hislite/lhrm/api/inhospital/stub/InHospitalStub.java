package com.nbteam.hislite.lhrm.api.inhospital.stub;

import com.nbteam.hislite.lhrm.api.inhospital.stub.hystrix.InHospitalHystrix;
import com.nbteam.hislite.lhrm.api.inhospital.vo.HisPatientExpenseVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InHosputalHisResultVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InhospitalOrdersParamVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: InHospitalStub
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2018-09-25 17:43
 */
@FeignClient(name= "hislite-lhrm-app",fallback = InHospitalHystrix.class)
//@FeignClient(name= "hislite-lhrm-app")
public interface InHospitalStub {

    /**
     * --------------------------------------------------------------------------------------
     * 住院对外接口 - 开始
     * --------------------------------------------------------------------------------------
     */
    @RequestMapping(value="/inhospital/inHospital/getPatientExpense",method = RequestMethod.POST)
    public HisPatientExpenseVo getPatientExpense(@RequestBody InhospitalOrdersParamVo params);

    @RequestMapping(value="/inhospital/inHospital/prePayExpense",method = RequestMethod.POST)
    public InHosputalHisResultVo prePayExpense(@RequestBody InhospitalOrdersParamVo params);
    /**
     * --------------------------------------------------------------------------------------
     * 住院对外接口 - 结束
     * --------------------------------------------------------------------------------------
     */


    /**
     * --------------------------------------------------------------------------------------
     * 住院对外模拟接口 - 开始
     * --------------------------------------------------------------------------------------
     */
    @RequestMapping(value="/inhospital/inHospital/getPatientExpenseMock",method = RequestMethod.POST)
    public HisPatientExpenseVo getPatientExpenseMock(@RequestBody InhospitalOrdersParamVo params);

    @RequestMapping(value="/inhospital/inHospital/prePayExpenseMock",method = RequestMethod.POST)
    public InHosputalHisResultVo prePayExpenseMock(@RequestBody InhospitalOrdersParamVo params);
    /**
     * --------------------------------------------------------------------------------------
     * 住院对外模拟接口 - 结束
     * --------------------------------------------------------------------------------------
     */
}
