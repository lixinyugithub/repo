package com.nbteam.hislite.payment.api.pay.stub;

import com.nbteam.hislite.payment.api.pay.stub.hystrix.PayHystrix;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderParamVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderResultVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "hislite-payment-app",fallback = PayHystrix.class)
public interface PayStub
{
	@RequestMapping(value="/pay/pay/registerPayOrder",method = RequestMethod.POST)
	public UnifiedOrderResultVo registerPayOrder(@RequestBody UnifiedOrderParamVo vo) ;

	@RequestMapping(value="/pay/pay/qrPayUnifiedOrder",method = RequestMethod.POST)
	public UnifiedOrderResultVo qrPayUnifiedOrder(@RequestBody UnifiedOrderParamVo vo) ;
}
