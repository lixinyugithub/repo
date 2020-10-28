package com.nbteam.hislite.his.outpatient.service;

import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.constant.CommonConstants;
import com.nbteam.hislite.common.utils.DateTool;
import com.nbteam.hislite.common.utils.ParamTool;
import com.nbteam.hislite.frame.service.SharedLockService;
import com.nbteam.hislite.his.api.common.constant.HisConstants;
import com.nbteam.hislite.his.api.exception.HisException;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrderSync;
import com.nbteam.hislite.his.api.outpatient.vo.OppayOrderVo;
import com.nbteam.hislite.his.outpatient.mapper.HisOppayOrderMapper;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import com.nbteam.hislite.lhrm.api.outpatient.stub.LhrmLoaderOppayStub;
import com.nbteam.hislite.lhrm.api.outpatient.vo.OppayOrdersParamVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.Oppayed2HisResultVo;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OppayOrderSendService
{
	private static final Logger logger = LoggerFactory.getLogger(OppayOrderSendService.class);

	@Autowired
	private SharedLockService sharedLockService;

	@Autowired
	private HisOppayOrderMapper hisOppayOrderMapper;

	@Autowired
	private SendSyncService sendSyncService;

	@Autowired
	private LhrmLoaderOppayStub lhrmLoaderOppayStub;

	@Value("${hislite.env.mock}")
	private boolean hisliteEnvMock;

	/**
	 * 异步发送门诊支付订单信息
	 * @param orderId
	 */
	public void sendForOppayOrderPayed(Long orderId) {
		HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(orderId);
		logger.info("订单：{}异步发送门诊支付订单信息", order.getOppayOrderId());
		String key = "sendForOppayOrderPayed" + order.getOppayOrderId();
		try {
			Boolean ok = sharedLockService.getShareLock(CommonConstants.GENERATOR_HIS_SYNC_KEY, key);
			if (!ok) {
				logger.info("该订单已经被其他请求锁住，orderId:{},取消重发操作", order.getOppayOrderId());
				return;
			}
			HisOppayOrderSync sync = sendSyncService.getOrderSync(order.getOppayOrderId(), order.getOppayOrderId(), "his", HisConstants.SEND_TYPE_PAYED, null);
			if (sync.getStatus() == HisConstants.ORDER_SYNC_SUCCESS) {
				logger.warn("订单{}支付后已发送医院，不需要重复锁定", order.getOppayOrderId());
				return;
			}
			if (!HisConstants.PAY_STATUS_PAYED.equals(order.getPayStatus())) {
				logger.warn("订单状态不属于支付状态，无需去发送订单");
				return;
			}
			// 重发
			if (!HisConstants.OPPAY_STATUS_PAYING.equals(order.getStatus()) && sync.getTimes() > 0) {
				logger.error("订单状态已改变,不再重发");
				return;
			}
			boolean syncStatus = false;
			boolean isRemoteException = false;
			boolean sendMsg = false;
			try {
				Map<String, Object> payed = createOppayVo(order, sync.getTimes());
				logger.info("发送门诊支付订单到医院：userId：{}， orderId：{}", order.getUserId(), order.getOppayOrderId());
				long currTime = System.currentTimeMillis();
				OppayOrdersParamVo paramsVo = new OppayOrdersParamVo();
				paramsVo.setHisId(order.getHisId());
				paramsVo.setExtProps(payed);
				Oppayed2HisResultVo result = null;
				if (hisliteEnvMock) {
					result = lhrmLoaderOppayStub.getHisOppayResultMock(paramsVo);
				}
				else {
					result = lhrmLoaderOppayStub.getHisOppayResult(paramsVo);
				}
				if (System.currentTimeMillis() - currTime > 2000) {
					logger.info("发送订单到远程医院费时：", System.currentTimeMillis() - currTime);
				}
				logger.info("发送门诊支付订单到医院返回数据：{}", JSONObject.toJSONString(result));
				if (HosConstants.RETURN_CODE_SUCCESS.equals(result.getResultCode())) {
					OppayOrderVo extendsOrder = new OppayOrderVo();
					extendsOrder.setId(order.getOppayOrderId());
					extendsOrder.setStatus(HisConstants.OPPAY_STATUS_HIS_PAYED);
					extendsOrder.setHisId(order.getHisId());
					extendsOrder.setHisRecepitNo(result.getHisRecepitNo());
					if (result.getExtFields() != null && !result.getExtFields().isEmpty()) {
						extendsOrder.setExtFields(JSONObject.toJSONString(result.getExtFields())); // 处理扩展字段数据
					}
					if (StringUtils.isNotBlank(result.getHisSerialNo())) {
						extendsOrder.setHisSerialNo(result.getHisSerialNo());
					}
					if (StringUtils.isNotBlank(result.getGuideInfo())) {
						extendsOrder.setGuideInfo(result.getGuideInfo());
					}
					updatePaySendHis(extendsOrder);
					syncStatus = true;
				} else if (StringUtils.isNotBlank(result.getResultCode())
						&& HisConstants.EXTENDS_RETURN_FAILURE_CODE.equals(result.getResultCode())) {
					// 医院返回错误，需要取消做退款处理
					OppayOrderVo extendsOrder = new OppayOrderVo();
					extendsOrder.setId(order.getOppayOrderId());
					extendsOrder.setStatus(HisConstants.OPPAY_STATUS_FAILURE);
					extendsOrder.setIsAutoRefund(CommonConstants.YES);
					extendsOrder.setHisId(order.getHisId());
					updatePaySendHis(extendsOrder);
					HisOppayOrder eOrder = SerializationUtils.clone(order);
					// TODO 失败退款后续开发
//					try {
//						processRefund(eOrder);
//					} catch (Exception e) {
//						logger.error("门诊缴费失败，退款处理失败：{}", JSONObject.toJSONString(order), e);
//					}
//					asyncProcessAdapter.notifyOppayedFailMsg(order);
				} else if (HisConstants.REMOTE_HIS_EXCEPTION_CODE.equals(result.getResultCode())) {
					isRemoteException = true;
					sendMsg = handerExceptionOrder(order, sync);
				} else {
					OppayOrderVo extendsOrder = new OppayOrderVo();
					extendsOrder.setId(order.getOppayOrderId());
					extendsOrder.setStatus(HisConstants.OPPAY_STATUS_PAYING);
					extendsOrder.setHisId(order.getHisId());
					extendsOrder.setHisRecepitNo(result.getHisRecepitNo());
					updatePaySendHis(extendsOrder);
					throw new HisException(1, "通知医院失败，这是异常订单");
				}
				// TODO 添加失败日志
//				createOrderLog(order.getOppayOrderId(), syncStatus, result.getResultMessage());
			} catch (Exception e) {
				logger.error("发送订单到医院his失败：{}", JSONObject.toJSONString(order), e);
				sync.setMemo("发送门诊支付订单到医院失败");
				if (!isRemoteException) {
					try {
						sendMsg = handerExceptionOrder(order, sync);
					} catch (Exception e1) {
						logger.error("门诊缴费异常订单处理异常order:{}", JSONObject.toJSONString(order), e);
					}
				}
				// TODO 失败后处理
//				ErrorOrder errorOrder = new ErrorOrder();
//				try {
//					errorOrder.setOrderId(order.getOppayOrderId());
//					errorOrder.setHisId(order.getHisId());
//					errorOrder.setChannel(order.getPlatformSource());
//					errorOrder.setStatus(0);
//					errorOrder.setAgtOrdNum(order.getAgtOrdNum());
//					errorOrder.setPatientId(order.getPatientId());
//					errorOrder.setPatientName(order.getPatientName());
//					errorOrder.setBusType(BizTypeEnum.OUTPATIENT.code);
//					errorOrder.setReason("发送门诊支付订单到医院失败");
//					errorOrder.setHisOrderNo(order.getHisOrderNo());
//					errorOrder.setHisCardNo(order.getPatCardNo());
//					errorOrder.setHisCardType(order.getPatCardType() == null ? null : order.getPatCardType().toString());
//					errorOrder.setOrderFee(order.getTotalRealFee());
//					errorOrder.setPayTime(order.getPayedTime());
//					errorOrderFacade.save(errorOrder);
//					asyncProcessAdapter.notifyOppayedExceptionMsg(order);
//				} catch (Exception e1) {
//					logger.error("插入异常订单失败,errorOrder is ", e);
//				}
			} finally {
				try {
					sendSyncService.saveSync(sync, syncStatus);
				} catch (Exception e) {
					logger.error("保存同步记录异常:{}", JSONObject.toJSONString(sync), e);
				}
				try {
					if (sendMsg) {
						// TODO： 推送支付重试消息
//						sendPayedRetryMsg(order.getOppayOrderId(), order.getHisId(), BizTypeEnum.OUTPATIENT, sync.getCreateTime());
					}
				} catch (Exception e) {
					logger.error("门诊缴费异常订单处理异常", e);
				}
			}
		} finally {
			sharedLockService.realseShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, key);
			if (logger.isDebugEnabled()) {
				logger.debug("异步发送门诊支付订单结束");
			}
		}
	}

	/**
	 * 门诊单发送重试
	 * @param order
	 * @param sync
	 * @return
	 */
	private boolean handerExceptionOrder(HisOppayOrder order, HisOppayOrderSync sync) {
		logger.info("进入门诊单发送重试order：{}, sync:{}", JSONObject.toJSONString(order),
				JSONObject.toJSONString(sync));
		boolean sendMsg = false;
		OppayOrderVo extendsOrder = new OppayOrderVo();
		extendsOrder.setId(order.getOppayOrderId());
		extendsOrder.setHisId(order.getHisId());
		// TODO 先不做失败重试，后续开发
//		PCDict dict = dictCenterFacade.getHisDicByType(order.getHisId(), "oppay_retry_flag");
		// 配置了重发才重发,否则直接抛异常
//		boolean flag = true;
//		if (dict != null && StringUtils.isNotBlank(dict.getDictValue())) {
//			HisProfile hisConf = hisProfileFacade.getHisProfileByHisIdAndKey(order.getHisId(), "max_repeat_send_times", context);
//			// 如果状态不为H则修改为H
//			if (!HisConstants.OPPAY_STATUS_PAYING.equals(order.getStatus())) {
//				extendsOrder.setStatus(OppayStatusEnum.paying.getCode());
//				updatePaySendHis(extendsOrder, context);
//			}
//			logger.info("sequence:{}, 开始执行门诊单发送重试", context.getMsgSeq());
//			boolean beOk = sharedLockService.getShareLock(order.getId(), context);
//			if (hisConf != null && Integer.parseInt(hisConf.getProfileValue()) > 0) {
//				if ((sync.getTimes() == null || sync.getTimes() < 1) && beOk) {
//					sharedLockService.getShareLock(order.getId(), context);
//					sendMsg = true;
//				} else {
//					flag = sync.getTimes() >= Integer.parseInt(hisConf.getProfileValue()) ? false : true;
//				}
//			} else {
//				flag = false;
//			}
//		} else {
//			flag = false;
//		}
//		logger.info("结束执行门诊单发送重试，结果：{}", flag);
//		if (!flag) {
//			extendsOrder.setStatus(HisConstants.OPPAY_STATUS_REMOTE_ERROR_TIMES);
//			updatePaySendHis(extendsOrder);
//			throw new HisException(HisException.DEFAULT_CODE, "调用医院接口未知");
//		}
		return sendMsg;
	}

	private void updatePaySendHis(OppayOrderVo extendsOrder) {
		HisOppayOrder hisOppayOrder = new HisOppayOrder();
		BeanUtils.copyProperties(extendsOrder, hisOppayOrder);
		hisOppayOrder.setOppayOrderId(extendsOrder.getId());
		hisOppayOrderMapper.updateByPrimaryKeySelective(hisOppayOrder);
	}

	private Map<String,Object> createOppayVo(HisOppayOrder order, Integer sendTimes) {
		Map<String, Object> payed = new HashMap<>();
		payed.put("agtOrdNum", order.getAgtOrdNum()); // 收单机构流水号
		payed.put("hisOrdNum", order.getHisOrderNo()); // 医院订单号
		payed.put("hisSerialNo", order.getHisSerialNo()); // 医院收据号
		payed.put("patCardNo", order.getPatCardNo()); // 就诊卡号
		payed.put("patCardType", String.valueOf(order.getPatCardType())); // 就诊卡类型
		payed.put("patHisNo", order.getPatHisNo()); // 患者门诊ID
		payed.put("patName", order.getPatientName());
		payed.put("patIdNo", order.getPatientIdNo());
		payed.put("patIdType", order.getPatientIdType());

		payed.put("totalAmt", ParamTool.getStringValue(order.getTotalFee())); // 支付金额
		payed.put("payAmt", ParamTool.getStringValue(order.getTotalRealFee())); // 实际支付金额
		payed.put("payMode", order.getPayType()); // 支付方式
		payed.put("payTime", DateTool.getFullDateTime().format(order.getPayedTime())); // 支付时间
		payed.put("psOrdNum", String.valueOf(order.getOppayOrderId())); // 平台订单号
		payed.put("platSource", String.valueOf(order.getPlatformSource())); // 平台来源
		payed.put("extFields", order.getExtFields()); // 扩展字段数据
		payed.put("sendTimes", sendTimes); // 发送次数，1为第一次发送，

		payed.put("medicalFlag", order.getMedicalFlag()); /** 医保标识：0 自费 1 医保 */
		payed.put("medicalFee", order.getMedicalFee()); /** 医保支付金额 */

		return payed;
	}

}
