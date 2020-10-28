package com.nbteam.hislite.his.api.outpatient.stub;

import com.nbteam.hislite.his.api.outpatient.stub.hystrix.OppayOrderHystrix;
import com.nbteam.hislite.his.api.outpatient.vo.PayResultVo;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "hislite-his-app",fallback = OppayOrderHystrix.class)
public interface OppayOrderStub
{
	@RequestMapping(value="/outpatient/oppayOrder/payResult",method = RequestMethod.POST)
	public Boolean payResult(@RequestBody @ApiParam("支付结果") PayResultVo payResultVo);

}
