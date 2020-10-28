package com.nbteam.hislite.lhrm.api.outpatient.stub.hystrix;

import com.nbteam.hislite.common.exception.BusinessException;
import com.nbteam.hislite.lhrm.api.outpatient.stub.LhrmLoaderOppayStub;
import com.nbteam.hislite.lhrm.api.outpatient.vo.*;
import org.springframework.stereotype.Component;

import java.util.List;

/****
 */
@Component
public class LhrmLoaderOppayHystrix implements LhrmLoaderOppayStub {

	@Override
	public List<HisOppayOrderVo> getHisOppayOrders(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getHisOppayOrders>>>>>");
	}

	@Override
	public HisOppayOrderVo checkOppayOrder(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:checkOppayOrder>>>>>");
	}

	@Override
	public CreateOppayOrderResultVo createOppayOrder(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:createOppayOrder>>>>>");
	}

	@Override
	public Oppayed2HisResultVo getHisOppayResult(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getHisOppayResult>>>>>");
	}

	@Override
	public QryOppayOrderStatusResultVo qryOppayOrderStatus(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:qryOppayOrderStatus>>>>>");
	}

	@Override
	public List<HisOppayOrderVo> getHisOppayOrdersMock(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getHisOppayOrdersMock>>>>>");
	}

	@Override
	public HisOppayOrderVo checkOppayOrderMock(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:checkOppayOrderMock>>>>>");
	}

	@Override
	public CreateOppayOrderResultVo createOppayOrderMock(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:createOppayOrderMock>>>>>");
	}

	public Oppayed2HisResultVo getHisOppayResultMock(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:getHisOppayResultMock>>>>>");
	}

	@Override
	public QryOppayOrderStatusResultVo qryOppayOrderStatusMock(OppayOrdersParamVo params) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:qryOppayOrderStatusMock>>>>>");
	}

}
