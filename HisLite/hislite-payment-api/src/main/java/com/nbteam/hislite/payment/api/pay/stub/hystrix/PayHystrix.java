package com.nbteam.hislite.payment.api.pay.stub.hystrix;

import com.nbteam.hislite.payment.api.pay.stub.PayStub;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderParamVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderResultVo;
import org.springframework.stereotype.Component;

/****
 */
@Component
public class PayHystrix implements PayStub {

	@Override
	public UnifiedOrderResultVo registerPayOrder(UnifiedOrderParamVo vo) {
		return null;
	}

	@Override
	public UnifiedOrderResultVo qrPayUnifiedOrder(UnifiedOrderParamVo vo) {
		return null;
	}
}
