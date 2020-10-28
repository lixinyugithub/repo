package com.nbteam.hislite.lhrm.api.outpatient.stub;

import com.nbteam.hislite.lhrm.api.outpatient.stub.hystrix.LhrmLoaderOppayHystrix;
import com.nbteam.hislite.lhrm.api.outpatient.vo.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name= "hislite-lhrm-app",fallback = LhrmLoaderOppayHystrix.class)
//@FeignClient(name= "hislite-lhrm-app")
public interface LhrmLoaderOppayStub
{

	/**
	 * --------------------------------------------------------------------------------------
	 * 门诊对外接口 - 开始
	 * --------------------------------------------------------------------------------------
	 */
	@RequestMapping(value="/outpatient/loaderOppay/getHisOppayOrders",method = RequestMethod.POST)
	public List<HisOppayOrderVo> getHisOppayOrders(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/checkOppayOrder",method = RequestMethod.POST)
	public HisOppayOrderVo checkOppayOrder(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/createOppayOrder",method = RequestMethod.POST)
	public CreateOppayOrderResultVo createOppayOrder(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/getHisOppayResult",method = RequestMethod.POST)
	public Oppayed2HisResultVo getHisOppayResult(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/qryOppayOrderStatus",method = RequestMethod.POST)
	public QryOppayOrderStatusResultVo qryOppayOrderStatus(@RequestBody OppayOrdersParamVo params);
	/**
	 * --------------------------------------------------------------------------------------
	 * 门诊对外接口 - 结束
	 * --------------------------------------------------------------------------------------
	 */


	/**
	 * --------------------------------------------------------------------------------------
	 * 门诊对外模拟接口 - 开始
	 * --------------------------------------------------------------------------------------
	 */
	@RequestMapping(value="/outpatient/loaderOppay/getHisOppayOrdersMock",method = RequestMethod.POST)
	public List<HisOppayOrderVo> getHisOppayOrdersMock(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/checkOppayOrderMock",method = RequestMethod.POST)
	public HisOppayOrderVo checkOppayOrderMock(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/createOppayOrderMock",method = RequestMethod.POST)
	public CreateOppayOrderResultVo createOppayOrderMock(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/getHisOppayResultMock",method = RequestMethod.POST)
	public Oppayed2HisResultVo getHisOppayResultMock(@RequestBody OppayOrdersParamVo params);

	@RequestMapping(value="/outpatient/loaderOppay/qryOppayOrderStatusMock",method = RequestMethod.POST)
	public QryOppayOrderStatusResultVo qryOppayOrderStatusMock(@RequestBody OppayOrdersParamVo params);
	/**
	 * --------------------------------------------------------------------------------------
	 * 门诊对外模拟接口 - 结束
	 * --------------------------------------------------------------------------------------
	 */



}
