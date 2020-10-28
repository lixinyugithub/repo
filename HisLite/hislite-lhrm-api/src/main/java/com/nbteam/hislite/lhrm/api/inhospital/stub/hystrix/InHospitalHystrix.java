package com.nbteam.hislite.lhrm.api.inhospital.stub.hystrix;

import com.nbteam.hislite.common.exception.BusinessException;
import com.nbteam.hislite.lhrm.api.inhospital.stub.InHospitalStub;
import com.nbteam.hislite.lhrm.api.inhospital.vo.HisPatientExpenseVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InHosputalHisResultVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InhospitalOrdersParamVo;
import org.springframework.stereotype.Component;

/****
 */
@Component
public class InHospitalHystrix implements InHospitalStub {


	@Override
	public HisPatientExpenseVo getPatientExpense(InhospitalOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getPatientExpense>>>>>");
	}

	@Override
	public InHosputalHisResultVo prePayExpense(InhospitalOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:prePayExpense>>>>>");
	}

	@Override
	public HisPatientExpenseVo getPatientExpenseMock(InhospitalOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getPatientExpenseMock>>>>>");
	}

	@Override
	public InHosputalHisResultVo prePayExpenseMock(InhospitalOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:prePayExpenseMock>>>>>");
	}
}
