package com.nbteam.hislite.his.inhospital.service;

import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.constant.CommonConstants;
import com.nbteam.hislite.common.utils.BeanUtilEx;
import com.nbteam.hislite.his.api.common.constant.HisConstants;
import com.nbteam.hislite.his.api.exception.HisException;
import com.nbteam.hislite.his.api.inhospital.dto.HisInhospitalOrder;
import com.nbteam.hislite.his.api.inhospital.vo.*;
import com.nbteam.hislite.his.inhospital.mapper.HisInhospitalOrderMapper;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import com.nbteam.hislite.lhrm.api.inhospital.stub.InHospitalStub;
import com.nbteam.hislite.lhrm.api.inhospital.vo.HisPatientExpenseVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InHosputalHisResultVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InhospitalOrdersParamVo;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.pay.stub.PayStub;
import com.nbteam.hislite.payment.api.pay.vo.QrResultVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderParamVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderResultVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InHospitalService {

	private static final Logger logger = LoggerFactory.getLogger(InHospitalService.class);

	@Autowired
	private InHospitalStub inHospitalStub;

	@Autowired
	private HisInhospitalOrderMapper hisInhospitalOrderMapper;

	@Autowired
	private PayStub payStub;

	@Value("${hislite.env.mock}")
	private boolean hisliteEnvMock;

	public InHospitalVo getRecentInHospital(Long hisId, String serialNumber) {
		// 获取住院信息
		HisPatientExpenseVo inHospitalRecordItemVo = getRecentInHospitalRecordVo(serialNumber);
		if (inHospitalRecordItemVo != null) {
			int total = 0;
			int balance = 0;
			if (StringUtils.isNotBlank(inHospitalRecordItemVo.getTotleAmt())) {
				total = Integer.valueOf(inHospitalRecordItemVo.getTotleAmt());
			}
			if (StringUtils.isNotBlank(inHospitalRecordItemVo.getRemainAmt())) {
				balance = Integer.valueOf(inHospitalRecordItemVo.getRemainAmt());
			}
			InHospitalVo vo = new InHospitalVo();
			BeanUtilEx.copyProperties(vo, inHospitalRecordItemVo);
			vo.setHisId(hisId);
			vo.setPatCardNo(serialNumber);
			vo.setHisId(hisId);
//			vo.setHisName(pvo.getHisName());
			vo.setBalance(balance);
			vo.setConsumeFee(total - balance);
//			vo.setPatientId(patientId);
			vo.setPatientName(inHospitalRecordItemVo.getPatientName());
			vo.setTotalFee(total);
			return vo;
		}
		return null;
	}

	private HisPatientExpenseVo getRecentInHospitalRecordVo(String serialNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("patCardNo", serialNumber);
		InhospitalOrdersParamVo inhospitalOrdersParamVo = new InhospitalOrdersParamVo();
		inhospitalOrdersParamVo.setHisId(1L);
		inhospitalOrdersParamVo.setExtProps(params);
		try {
			HisPatientExpenseVo pihrvo = inHospitalStub.getPatientExpenseMock(inhospitalOrdersParamVo);
			if (pihrvo != null) {
				if (HosConstants.RETURN_CODE_SUCCESS.equals(pihrvo.getResultCode())) {
					return pihrvo;
				} else {
					logger.info("获取住院信息错误 :4{}", JSONObject.toJSONString(pihrvo));
					throw new HisException(HisException.HIS_BIZ_ERROR, "无住院记录");
				}
			}
			return null;
		} catch (Exception e) {
			logger.error("获取住院信息异常", e);
			throw new HisException(HisException.HIS_UNKNOWN_ERROR, "无住院记录");
		}
	}

	public InHospitalOrderVo generatorInHospitalOrder(InHospitalParamsVo params) {
		if (null == params.getHisId()) {
			throw new HisException(HisException.PARAM_ERROR, "参数[hisId]非空校验失败");
		}

        /* 去his查询信息 */
		HisPatientExpenseVo inHospitalVo = getRecentInHospitalRecordVo(params.getAdmissionNum());
		try {
			HisInhospitalOrder inHospitalOrder = new HisInhospitalOrder();
			inHospitalOrder.setPlatformId(params.getPlatformId());
//			inHospitalOrder.setBedNo(inHospitalVo.getBedNo());
			inHospitalOrder.setPlatformSource(params.getPlatformSource());
			inHospitalOrder.setCreateTime(new Date());
//			inHospitalOrder.setDeptName(inHospitalVo.getDeptName());
//			inHospitalOrder.setPatCardNo(inHospitalVo.getPatCardNo());
//			inHospitalOrder.setPatCardType(inHospitalVo.getPatCardType());
			inHospitalOrder.setHisId(params.getHisId());
//			inHospitalOrder.setHisName(inHospitalVo.getHisName());
//			inHospitalOrder.setIdNo(inHospitalVo.getIdNo());
//			inHospitalOrder.setIdType(inHospitalVo.getIdType());
//			inHospitalOrder.setPatientId(patientId);
//			inHospitalOrder.setPatientMobile(inHospitalVo.getMobile());
//			inHospitalOrder.setPatientName(inHospitalVo.getPatName());
			inHospitalOrder.setPayFee(Integer.valueOf(params.getPrice()));
			inHospitalOrder.setPayStatus(0);
			inHospitalOrder.setAdmissionNum(params.getAdmissionNum());
//			inHospitalOrder.setUserId(user.getId());
//			inHospitalOrder.setUserMobile(user.getMobile());
			inHospitalOrder.setStatus(HisConstants.INHOSPITAL_ORDER_STATUS_INIT);
//			inHospitalOrder.setExtFields(inHospitalVo.getOtherDesc());
//			inHospitalOrder.setInhospitalNo(inHospitalVo.getInhospitalNo());
			inHospitalOrder.setHisOrderNo(inHospitalVo.getHisNo());
			hisInhospitalOrderMapper.insertSelective(inHospitalOrder);
			InHospitalOrderVo orderVo = null;
			if (inHospitalOrder != null) {
				orderVo = new InHospitalOrderVo();
				BeanUtilEx.copyProperties(orderVo, inHospitalOrder);
			}
			return orderVo;
		} catch (Exception e) {
			logger.error("住院押金补缴下单失败：{}", e.getMessage());
			throw new HisException(HisException.PARAM_ERROR, "住院押金补缴下单失败");
		}
	}

	public CreatePayOrderResultVo registerPayOrder(InHospitalOrderVo order) {
		logger.info("支付中心下单入参：{}", JSONObject.toJSONString(order));
		UnifiedOrderParamVo paramVo = new UnifiedOrderParamVo();
		paramVo.setHisName(order.getHisName());
		paramVo.setBizChannel(String.valueOf(order.getPlatformSource()));
		paramVo.setBizType(HisConstants.BIZ_TYPE_INPATIENT);
//		paramVo.setChannelUserId(userVo.getChannelId());
		paramVo.setPayChannel(CommonConstants.PAY_TYPE_MAP.get(order.getPayType()));
		paramVo.setUserId(order.getUserId());
		paramVo.setGoodsName(order.getHisName() + "住院押金补缴");
		paramVo.setTotalFee(order.getPayFee());
		paramVo.setBizOrderId(order.getInhospitalOrderId());
		paramVo.setPayMethod(PaymentConstants.PAY_METHOD_QR);
		paramVo.setEffectiveLength(-1);
//		paramVo.setIpAddress(context.getClientIP());
		paramVo.setBizContent(order.getBizContent());
		paramVo.setHisId(order.getHisId());
		UnifiedOrderResultVo unifiedOrderResultVo = payStub.registerPayOrder(paramVo);
		logger.info("支付中心下单返回：{}", JSONObject.toJSONString(unifiedOrderResultVo));
		if (PaymentConstants.RESULT_SUCCESS_CODE.equals(unifiedOrderResultVo.getResultCode())) {
            /* 更新订单 */
			HisInhospitalOrder updateOrder = new HisInhospitalOrder();
			updateOrder.setInhospitalOrderId(order.getInhospitalOrderId());
			updateOrder.setPayOrderId(unifiedOrderResultVo.getPayOrderId());
			hisInhospitalOrderMapper.updateByPrimaryKeySelective(updateOrder);

            /* 封装返回对象 */
			CreatePayOrderResultVo createPayOrderResultVo = new CreatePayOrderResultVo();
			createPayOrderResultVo.setCashierURI(unifiedOrderResultVo.getCashierURI());
			createPayOrderResultVo.setPayOrderId(null == unifiedOrderResultVo.getPayOrderId() ? "" : String.valueOf(unifiedOrderResultVo.getPayOrderId()));
			if (CollectionUtils.isNotEmpty(unifiedOrderResultVo.getQrList())) {
				List<QrQueryResultVo> list = new ArrayList<>();
				QrQueryResultVo qrQueryResultVo = null;
				for (QrResultVo qrResultVo : unifiedOrderResultVo.getQrList()) {
					qrQueryResultVo = new QrQueryResultVo();
					BeanUtilEx.copyProperties(qrQueryResultVo, qrResultVo);
					list.add(qrQueryResultVo);
				}
				createPayOrderResultVo.setQrList(list);
			}
			return createPayOrderResultVo;
		} else {
			throw new HisException(HisException.PAY_CREATE_ORDER_EXCEPTION_CODE,
					unifiedOrderResultVo.getResultMsg());
		}
	}

	public Boolean orderPayJudge(Long orderId) {
		/** 判断支付是否成功 */
		HisInhospitalOrder inOrder = hisInhospitalOrderMapper.selectByPrimaryKey(orderId);
		if (inOrder == null) {
			logger.error("找不到对应的住院缴费单信息");
			throw new HisException(HisException.HIS_BIZ_ERROR, "找不到对应的住院缴费单信息");
		}
		if (!HisConstants.INHOSPITAL_ORDER_STATUS_HIS_EXCEPTION.equals(inOrder.getStatus()) && inOrder.getRenoticeNum() > 1) {
			logger.error("订单状态已改变,不再重发");
			return true;
		}

		try {
//			String patHisNo = "";
//			String parentName = "";
//			String parentIdNo = "";
//			String parentIdType = "";

            /* 查询就诊人信息 */
//			if (null != inOrder.getPatientId()) {
//				PatientsVo patient = patientsFacade.getPatientById(inOrder.getPatientId(), context);
//				if (null != patient) {
//					patHisNo = patient.getPatHisNo();
//					parentName = patient.getParentName();
//					parentIdNo = patient.getParentIdNo();
//					parentIdType = null == patient.getParentIdType() ? "" : String.valueOf(patient.getParentIdType());
//				}
//			}


			Map<String, Object> params = new HashMap<String, Object>();
			params.put("patientName", inOrder.getPatientName());
			params.put("patCardNo", inOrder.getPatCardNo());
			params.put("prepayAmt", String.valueOf(inOrder.getPayFee()));
			params.put("tradeNo", inOrder.getAcquirerNo());


			params.put("extFields", inOrder.getExtFields());
			params.put("orderId", String.valueOf(inOrder.getInhospitalOrderId()));
			params.put("inhospitalNo", inOrder.getInhospitalNo());
			params.put("sendTimes", null == inOrder.getRenoticeNum() ? "0":String.valueOf(inOrder.getRenoticeNum()));
			params.put("platformSource",String.valueOf(inOrder.getPlatformSource()));

			/** 通知医院缴费成功 */
			InhospitalOrdersParamVo inhospitalOrdersParamVo = new InhospitalOrdersParamVo();
			inhospitalOrdersParamVo.setHisId(1L);
			inhospitalOrdersParamVo.setExtProps(params);
			InHosputalHisResultVo inVo = inHospitalStub.prePayExpenseMock(inhospitalOrdersParamVo);
			logger.info("支付通知医院返回数据:{}", JSONObject.toJSONString(inVo));
			if (HosConstants.RETURN_CODE_SUCCESS.equals(inVo.getResultCode())) {
				HisInhospitalOrder updateOrder = new HisInhospitalOrder();
				updateOrder.setInhospitalOrderId(inOrder.getInhospitalOrderId());
				updateOrder.setStatus(HisConstants.INHOSPITAL_ORDER_STATUS_HIS_PAYED);
				updateOrder.setRefundStatus(HisConstants.INHOSPITAL_ORDER_REFUND_STATUS_INIT);
				updateOrder.setHisOrderNo(inVo.getHisSerialNo());
				updateOrder.setHisRecepitNo(inVo.getHisRecepitNo());
				if(null != inVo.getExtFields()) {
					updateOrder.setExtFields(JSONObject.toJSONString(JSONObject.toJSONString(inVo.getExtFields())));
				}
				hisInhospitalOrderMapper.updateByPrimaryKeySelective(updateOrder);
			} else if (HosConstants.RETURN_CODE_FAIL.equals(inVo.getResultCode())) {
				try {
					HisInhospitalOrder updateOrder = new HisInhospitalOrder();
					updateOrder.setInhospitalOrderId(inOrder.getInhospitalOrderId());
					updateOrder.setStatus(HisConstants.INHOSPITAL_ORDER_STATUS_HIS_PAYED);
					updateOrder.setRefundStatus(HisConstants.INHOSPITAL_ORDER_REFUND_STATUS_REFUNDINGS);
					updateOrder.setErrorMsg(inVo.getResultMsg());
					hisInhospitalOrderMapper.updateByPrimaryKeySelective(updateOrder);
					// TODO 缴费失败发起退款
//					InpatientRefundParamVo reFundVo = new InpatientRefundParamVo();
//					reFundVo.setHisSerialNo(inOrder.getHisOrderNo());
//					reFundVo.setOrderId(inOrder.getId());
//					reFundVo.setRefundFee(inOrder.getPayFee());
//					reFundVo.setSourceType(2);
//					/** 缴费失败退款操作 */
//					inpatientRefundFacade.refund(reFundVo, context);
//
//					// 缴费失败模板消息
//					int type = TemplateMsgTypeEnum.INPATIENT_FAIL.getCode();
//					notifyPayFailedMsg(inOrder, type, context);
				} catch (Exception e) {
					logger.error("住院押金补缴失败，退款异常", e.getMessage());
				}
			} else if (HosConstants.RETURN_CODE_UNKNOW.equals(inVo.getResultCode())) {

				// 判断是否支持重发
				boolean flag = false;
//				// 查询配置表医院是否支持重发
//				PCDict dict = dictCenterFacade.getHisDicByType(inOrder.getHisId(), "inhospital_retry_flag", context);
//				if (dict != null && StringUtils.isNotBlank(dict.getDictValue())) {
//					// 查询医院配置的重发次数
//					HisProfile hisConf = hisProfileFacade.getHisProfileByHisIdAndKey(inOrder.getHisId(), "max_repeat_send_times",
//							context);
//					// 如果订单状态为改变，则先改变订单状态
//					if (!InhospitalOrderStatusEnum.his_exception.getCode().equals(inOrder.getStatus())) {
//						InHospitalOrder updateOrder = new InHospitalOrder();
//						updateOrder.setId(inOrder.getId());
//						updateOrder.setStatus(InhospitalOrderStatusEnum.his_exception.getCode());
//						inHospitalOrderService.updateInOrderStatusById(updateOrder);
//					}
//					// 如果医院配置了重发次数，并且还未进行过重发，则重发小时，重发次数由daemon-center控制
//					if (hisConf != null && Integer.parseInt(hisConf.getProfileValue()) > 0) {
//						if (inOrder.getRenoticeNum() == null || inOrder.getRenoticeNum() < 1) {
//							sendPayedRetryMsg(inOrder.getId(), inOrder.getHisId(), BizTypeEnum.INPATIENT, context);
//						} else if (inOrder.getRenoticeNum() >= Integer.parseInt(hisConf.getProfileValue())) {
//							// 如果重发次数已经大于最大重发次数，则抛出异常
//							flag = false;
//						}
//					} else {
//						flag = false;
//					}
//				} else {
//					flag = false;
//				}
				// TODO 缴费失败重发
				HisInhospitalOrder updateOrder = new HisInhospitalOrder();
				updateOrder.setInhospitalOrderId(inOrder.getInhospitalOrderId());
				updateOrder.setRenoticeNum(inOrder.getRenoticeNum() == null ? 0 : inOrder.getRenoticeNum() + 1);
				updateOrder.setStatus(flag ? null : HisConstants.INHOSPITAL_ORDER_STATUS_HIS_EXCEPTION_END);
				hisInhospitalOrderMapper.updateByPrimaryKeySelective(updateOrder);
				if (!flag) {
					throw new HisException(HisException.HIS_BIZ_ERROR, "重发次数达到上限");
				}
				return false;
			}
			// 发送通知到医院
			if (HosConstants.RETURN_CODE_SUCCESS.equals(inVo.getResultCode())) {
//				int type = TemplateMsgTypeEnum.INPATIENT_SUCCESS.getCode();
//				notifyPayedSuccessMsg(inOrder, type);
				notifyPayedSuccessMsg(inOrder);
			}
		} catch (Exception e) {
			logger.info("判断支付是否成功 异常 ", e);
			if (e instanceof HisException) {
				try {
					// TODO 通知异常发起退款
//					ErrorOrder errorOrder = new ErrorOrder();
//					errorOrder.setOrderId(inOrder.getId());
//					errorOrder.setHisId(inOrder.getHisId());
//					errorOrder.setChannel(inOrder.getPlatformSource());
//					errorOrder.setStatus(0);
//					errorOrder.setAgtOrdNum(inOrder.getAcquirerNo());
//					errorOrder.setPatientId(inOrder.getPatientId());
//					errorOrder.setPatientName(inOrder.getPatientName());
//					errorOrder.setBusType(BizTypeEnum.INPATIENT.code);
//					errorOrder.setReason("发送住院支付订单到医院失败");
//					errorOrder.setHisOrderNo(inOrder.getHisOrderNo());
//					errorOrder.setInhospitalNo(inOrder.getAdmissionNum());
//					errorOrder.setHisCardNo(inOrder.getPatCardNo());
//					errorOrder.setHisCardType(inOrder.getPatCardType() == null ? null : inOrder.getPatCardType().toString());
//					errorOrder.setOrderFee(inOrder.getPayFee());
//					errorOrder.setPayTime(inOrder.getPayedTime());
//					errorOrderFacade.save(errorOrder, context);
//					int type = TemplateMsgTypeEnum.INPATIENT_EXCEPTION.getCode();
//					notifyRefundErrorMsg(inOrder, type, context);
				} catch (Exception e1) {
					logger.error("保存异常订单出错", e1);
				}
			}
		}
		return true;
	}

	private void notifyPayedSuccessMsg(HisInhospitalOrder order) {
		try {
//            /* 住院缴费模板消息 */
//			String messageData = "";
//			Integer noticeType = PlatformToNotifyType.getNotifyType(order.getPlatformSource());
//			if (null == noticeType) {
//				logger.error("暂不支持{}渠道消息发送", PlatformSourceEnum.toCName(order.getPlatformSource()));
//			}
//			Long msgId = idGenerator.next(IDGeneratorTypeEnum.t_uc_wx_template_msg.name()).id;
//			NotifyRecord record = new NotifyRecord();
//			record.setNotifyType(noticeType);
//			record.setIdentifyId(String.valueOf(msgId));
//			record.setTemplateMsgType(templateMsgType);
//			TemplateMsgVo templateMsgVo = new TemplateMsgVo();
//			templateMsgVo.setMsgId(msgId);
//			templateMsgVo.setHisId(order.getHisId());
//			templateMsgVo.setTemplateMsgType(templateMsgType);
//			record.setFormId(context.getAttr("formId") == null ? "" : String.valueOf(context.getAttr("formId")));
//			templateMsgVo.setPlatformId(order.getPlatformId());
//			templateMsgVo.setUserId(order.getUserId());
//			templateMsgVo.setIdentifyId(String.valueOf(order.getId()));
//			String payedTime = DateTool.getFullDateTime().format(order.getPayedTime());
//			Map<String, Object> map = MapTool.beanToMap(order);
//			int pa = order.getPayFee() / 100;
//			int yf = order.getPayFee() / 10 % 10;
//			int fe = order.getPayFee() % 10;
//			String payFee = pa + "." + yf + fe;
//			map.put("payFee", payFee);
//			map.put("payedTime", payedTime);
//			map.put("orderId", order.getId());
//			templateMsgVo.setParamMap(map);
//			templateMsgVo.setPlatformSource(order.getPlatformSource());
//			messageData = JSONObject.toJSONString(templateMsgVo);
//			record.setMsg(messageData);
//			try {
//				WxTemplateMsg msg = new WxTemplateMsg();
//				msg.setHisId(order.getHisId());
//				msg.setId(msgId);
//				msg.setPlatformId(order.getPlatformId());
//				msg.setReadStatus(0);
//				msg.setSyncStatus("false");
//				msg.setPlatformSource(order.getPlatformSource());
//				msg.setTemplateContent(messageData);
//				msg.setUserId(order.getUserId());
//				msg.setOrderId(order.getId());
//				msg.setModuleId(templateMsgType);
//				userFacade.saveWxTemplateMsg(msg, context);
//			} catch (Exception e) {
//				logger.error("notifyPayedSuccessMsg保存消息体失败", e);
//			}
//			commonMQProducer.sendMessage(JSONObject.toJSONString(record));
//			logger.info("notifyPayedSuccessMsg发送消息成功：{}", JSONObject.toJSONString(record));
		} catch (Exception e) {
			logger.error("sequence:{}, notifyPayedSuccessMsg保存消息体失败", e);
		}
	}
}
