package com.nbteam.hislite.his.api.outpatient.stub.hystrix;

import com.nbteam.hislite.common.exception.BusinessException;
import com.nbteam.hislite.his.api.outpatient.stub.OppayOrderStub;
import com.nbteam.hislite.his.api.outpatient.vo.PayResultVo;
import org.springframework.stereotype.Component;

/****
 */
@Component
public class OppayOrderHystrix implements OppayOrderStub {


	@Override
	public Boolean payResult(PayResultVo payResultVo) {
		throw new BusinessException(BusinessException.METHOD_CALL_ERROR,">>>>Method:payResult>>>>>");
	}
}
