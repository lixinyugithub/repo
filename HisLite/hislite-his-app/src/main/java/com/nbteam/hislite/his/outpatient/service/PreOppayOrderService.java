package com.nbteam.hislite.his.outpatient.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.exception.BizException;
import com.nbteam.hislite.common.utils.StringUtil;
import com.nbteam.hislite.his.api.exception.HisException;
import com.nbteam.hislite.his.api.outpatient.vo.PreOppayParamsVo;
import com.nbteam.hislite.his.api.outpatient.vo.WaitPayOrderVo;
import com.nbteam.hislite.lhrm.api.outpatient.stub.LhrmLoaderOppayStub;
import com.nbteam.hislite.lhrm.api.outpatient.vo.HisOppayOrderVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.OppayOrdersParamVo;

@Service
public class PreOppayOrderService {

	private static final Logger logger = LoggerFactory.getLogger(PreOppayOrderService.class);

	@Value("${hislite.env.mock}")
	private boolean hisliteEnvMock;

	@Autowired
	private LhrmLoaderOppayStub lhrmLoaderOppayStub;

	public List<WaitPayOrderVo> getWaitPayOrders(PreOppayParamsVo params) {
		logger.info("获取门诊缴费待付款列表：{}", JSONObject.toJSONString(params));
		try {
			if (params == null || params.getHisId() == null || StringUtil.isEmpty(params.getPatCardNo())
					|| StringUtil.isEmpty(params.getPatientName())) {
				logger.error("获取门诊缴费待付款列表参数不能为空");
				throw new HisException(HisException.INVALIDATE_DATE_ERROR, "参数异常");
			}
			Map<String, Object> map = new HashMap<>();
			if (params.getExtProps() != null) {
				map = params.getExtProps();
			}
			map.put("patCardNo", params.getPatCardNo());
			map.put("patientName", params.getPatientName());
			OppayOrdersParamVo paramsVo = new OppayOrdersParamVo();
			paramsVo.setHisId(params.getHisId());
			paramsVo.setExtProps(map);

			List<HisOppayOrderVo> opList = null;
			if (hisliteEnvMock) {
				opList = lhrmLoaderOppayStub.getHisOppayOrdersMock(paramsVo);
			}
			else {
				opList = lhrmLoaderOppayStub.getHisOppayOrders(paramsVo);
			}
			List<WaitPayOrderVo> payList = new ArrayList<>(opList.size());
			if (opList != null && !opList.isEmpty()) {
				for (HisOppayOrderVo hisOrder : opList) {
					WaitPayOrderVo payOrder = new WaitPayOrderVo();
					BeanUtils.copyProperties(hisOrder, payOrder);
					payList.add(payOrder);
				}
			}
			return payList;
		} catch (BizException e) {
			throw e;
		} catch (Throwable e) {
			logger.error("获取门诊缴费待付款列表异常", e);
			throw new HisException(HisException.REGISTER_UNKNOWN_ERROR, "获取门诊缴费待付款列表异常");
		}

	}
}
