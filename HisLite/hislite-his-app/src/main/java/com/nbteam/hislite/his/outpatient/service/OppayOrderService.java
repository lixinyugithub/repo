package com.nbteam.hislite.his.outpatient.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.constant.CommonConstants;
import com.nbteam.hislite.common.exception.BizException;
import com.nbteam.hislite.frame.service.SharedLockService;
import com.nbteam.hislite.his.api.common.constant.HisConstants;
import com.nbteam.hislite.his.api.exception.HisException;
import com.nbteam.hislite.his.api.his.dto.HospitalHis;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrderSync;
import com.nbteam.hislite.his.api.outpatient.vo.*;
import com.nbteam.hislite.his.his.mapper.HospitalHisMapper;
import com.nbteam.hislite.his.outpatient.mapper.HisOppayOrderMapper;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import com.nbteam.hislite.lhrm.api.outpatient.stub.LhrmLoaderOppayStub;
import com.nbteam.hislite.lhrm.api.outpatient.vo.HisOppayOrderVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.OppayOrdersParamVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.QryOppayOrderStatusResultVo;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.pay.stub.PayStub;
import com.nbteam.hislite.payment.api.pay.vo.QrResultVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderParamVo;
import com.nbteam.hislite.payment.api.pay.vo.UnifiedOrderResultVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OppayOrderService {
	private static final Logger logger = LoggerFactory.getLogger(OppayOrderService.class);

	@Autowired
	private PayStub payStub;

	@Autowired
	private HisOppayOrderMapper hisOppayOrderMapper;

	@Autowired
	private SendSyncService sendSyncService;

	@Autowired
	private OppayOrderSendService oppayOrderSendService;

	@Autowired
	private SharedLockService sharedLockService;

	@Autowired
	private HospitalHisMapper hospitalHisMapper;

	@Autowired
	private LhrmLoaderOppayStub lhrmLoaderOppayStub;

	@Value("${hislite.env.mock}")
	private boolean hisliteEnvMock;

	/**
	 * 支付中心
	 * 
	 * @param orderParamVo
	 * @return
	 */
	public PayOrderCreateResultVo registerPayOrder(PayOrderParamVo orderParamVo) {
		logger.info("支付中心下单入参：{}", JSONObject.toJSONString(orderParamVo));
		UnifiedOrderParamVo paramVo = null;
		if (HisConstants.BIZ_TYPE_OUTPATIENT.equals(orderParamVo.getOrderType())) {
			paramVo = this.createUnifiedOrderForOppay(orderParamVo);
		} else {
			throw new HisException(HisException.BUSINESS_ERROR_CODE, orderParamVo.getOrderType());
		}
		logger.info("支付中心下单入参：{}", JSONObject.toJSONString(paramVo));
		UnifiedOrderResultVo unifiedOrderResultVo = payStub.qrPayUnifiedOrder(paramVo);
		logger.info("支付中心下单返回：{}", JSONObject.toJSONString(unifiedOrderResultVo));
		if (PaymentConstants.RESULT_SUCCESS_CODE.equals(unifiedOrderResultVo.getResultCode())) {
			/* 更新业务订单支付订单信息 */
			if (HisConstants.BIZ_TYPE_OUTPATIENT.equals(orderParamVo.getOrderType())) {
				HisOppayOrder oppayOrder = new HisOppayOrder();
				oppayOrder.setOppayOrderId(orderParamVo.getOrderId());
				oppayOrder.setPayOrderId(unifiedOrderResultVo.getPayOrderId());
				hisOppayOrderMapper.updateByPrimaryKeySelective(oppayOrder);
			} else {
				throw new HisException(HisException.BUSINESS_ERROR_CODE, orderParamVo.getOrderType());
			}
			/* 封装返回对象 */
			PayOrderCreateResultVo createPayOrderResultVo = new PayOrderCreateResultVo();
			createPayOrderResultVo.setCashierURI(unifiedOrderResultVo.getCashierURI());
			createPayOrderResultVo.setPayOrderId(unifiedOrderResultVo.getPayOrderId());
			createPayOrderResultVo.setTradeNo(unifiedOrderResultVo.getTradeNo());
			if (CollectionUtils.isNotEmpty(unifiedOrderResultVo.getQrList())) {
				List<QrQueryResultVo> list = new ArrayList<>();
				QrQueryResultVo qrQueryResultVo = null;
				for (QrResultVo qrResultVo : unifiedOrderResultVo.getQrList()) {
					qrQueryResultVo = new QrQueryResultVo();
					BeanUtils.copyProperties(qrResultVo, qrQueryResultVo);
					list.add(qrQueryResultVo);
				}
				createPayOrderResultVo.setQrList(list);
			}
			return createPayOrderResultVo;
		} else {
			throw new HisException(HisException.PAY_CREATE_ORDER_EXCEPTION_CODE, unifiedOrderResultVo.getResultMsg());
		}
	}

	/**
	 * 创建门诊缴费支付订单信息
	 * 
	 * @param orderParamVo
	 * @return
	 */
	private UnifiedOrderParamVo createUnifiedOrderForOppay(PayOrderParamVo orderParamVo) {
		logger.info("创建门诊缴费支付订单信息入参：{}", JSONObject.toJSONString(orderParamVo));
		HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(orderParamVo.getOrderId());
		if (order == null) {
			throw new HisException(HisException.PAY_CREATE_ORDER_EXCEPTION_CODE, "订单信息不存在");
		}
		UnifiedOrderParamVo paramVo = new UnifiedOrderParamVo();
		paramVo.setHisName(order.getHisName());
		paramVo.setBizChannel(String.valueOf(order.getPlatformSource()));
		paramVo.setBizType(HisConstants.BIZ_TYPE_OUTPATIENT);
		paramVo.setChannelUserId(orderParamVo.getChannelId());
		paramVo.setUserId(orderParamVo.getUserId());
		paramVo.setGoodsName(order.getHisName() + "-" + HisConstants.BIZ_TYPE_OUTPATIENT);
		paramVo.setTotalFee(order.getTotalRealFee());
		paramVo.setBizOrderId(order.getOppayOrderId());
		paramVo.setEffectiveLength(-1);
		// paramVo.setIpAddress(context.getClientIP());
		paramVo.setPayMethod(orderParamVo.getPayMethod());
		paramVo.setPayChannel(orderParamVo.getPayChannel());
		paramVo.setHisId(order.getHisId());
		paramVo.setHisName(order.getHisName());
		paramVo.setBizContent(orderParamVo.getBizContent());
		//新增
		paramVo.setHisOrderNo(order.getHisOrderNo());
		paramVo.setHisBillNo(order.getHisBillNo());
		if (order.getMedicalFlag() != null) {
			if (order.getMedicalFlag() == 1) { // 医保
				// /** 是否只支持医保支付 1-是 0-否 */
				throw new HisException(HisException.PARAMS_INVALIDATE_ERROR, "不支持医保");
			}
		}
		return paramVo;
	}

	public Boolean notifyExternal(Long orderId, String orderType) {
		logger.info("订单{}创建成功，调用医院接口锁定号源", orderId);
		if (true) {
			oppayOrderSendService.sendForOppayOrderPayed(orderId);
		}
		// 获取同步状态，后面需要优化此处，临时修改为了兼容mq消息的重发机制
		HisOppayOrderSync sync = sendSyncService.getOrderSync(orderId, orderId, "his",
				HisConstants.OPPAY_STATUS_PAYED, null);
		return HisConstants.ORDER_SYNC_SUCCESS.equals(sync.getStatus());
	}

	public Boolean payResult(PayResultVo payResultVo) {
		logger.info("支付成功回调：{}", payResultVo);
		paySingleResult(payResultVo);
		return true;
	}

	private void paySingleResult(PayResultVo result) {
		payOrder(result);
		notifyExternal(result.getOrderId(), result.getOrderType());
	}

	/**
	 * 支付订单
	 * 
	 * @param result
	 */
	private void payOrder(PayResultVo result) {
		if (HisConstants.BIZ_TYPE_OUTPATIENT.equals(result.getOrderType())) {
			changeOppayStatus(result);
		}
	}

	/**
	 *
	 * 更改门诊缴费单状态. <br/>
	 *
	 * @param result
	 */
	private void changeOppayStatus(PayResultVo result) {
		HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(result.getOrderId());
		if (order == null) {
			logger.error("sequence:{}, 支付的订单不存在：{}", JSONObject.toJSONString(result));
			throw new HisException(HisException.INVALIDATE_DATE_ERROR, "支付的订单不存在");
		}
		// 已支付订单，报异常信息
		if (HisConstants.PAY_STATUS_PAYED.equals(order.getPayStatus())) {
			logger.error("业务订单{}已经是支付状态，无法改变支付状态", order.getOppayOrderId());
			return;
		}
		OrderStatusChangeVo vo = createChangeOrder(result, order.getOppayOrderId(), HisConstants.OPPAY_STATUS_PAYED);
		if (vo.getMedicalFlag() != null && vo.getMedicalFlag() != 1) {
			String extFields = order.getExtFields();
			JSONObject jsonObject = new JSONObject();
			if (StringUtils.isNotBlank(extFields)) {
				jsonObject = JSONObject.parseObject(extFields);
			}
			// jsonObject.put("medicalCardId",result.getMedicalCardId());
			jsonObject.put("orgNo", result.getOrgNo());
			vo.setExtFields(extFields);
		}
		updateOrderPayStatus(vo);
	}

	/**
	 * 订单支付状态改变
	 * 
	 * @param vo
	 */
	private Boolean updateOrderPayStatus(OrderStatusChangeVo vo) {
		// OrderLog log = new OrderLog();
		// Long logId = idGenerator.next(IDGeneratorTypeEnum.t_rc_order_log.name()).id;
		// log.setId(logId);
		// log.setOperator(vo.getOperator());
		// log.setOperatorRole(vo.getOperatorRole());
		// log.setOrderId(vo.getId());
		// log.setContext("订单支付状态改变");
		// log.setMemo(vo.getMemo());

		OppayOrderVo order = new OppayOrderVo();
		order.setId(vo.getId());
		order.setPayedTime(vo.getPayedTime());
		order.setPayStatus(vo.getPayStatus());
		order.setPayType(vo.getPayType());
		order.setTotalRealFee(vo.getTotalRealFee());
		order.setAgtOrdNum(vo.getAgtOrdNum());
		order.setStatus(vo.getStatus());
		// 1-自费 2-全医保 3-医保+自费
		if (vo.getMedicalFlag() != null && vo.getMedicalFlag() != 1) {
			order.setMedicalFee(vo.getMedicareFee());
			order.setMedicalFlag(vo.getMedicalFlag()); // 医保
			if (StringUtils.isNotBlank(vo.getExtFields())) {
				order.setExtFields(vo.getExtFields());
			}
		}
		HisOppayOrder hisOppayOrder = new HisOppayOrder();
		BeanUtils.copyProperties(order, hisOppayOrder);
		hisOppayOrder.setOppayOrderId(order.getId());

		hisOppayOrderMapper.updateByPrimaryKeySelective(hisOppayOrder);
		return true;
	}

	/**
	 *
	 * 生成订单改变状态对象. <br/>
	 *
	 * @return
	 */
	private OrderStatusChangeVo createChangeOrder(PayResultVo result, Long orderId, String orderStatus) {
		OrderStatusChangeVo vo = new OrderStatusChangeVo();
		vo.setId(orderId);
		if (HisConstants.EXTENDS_RETURN_SUCCSS_CODE.equals(result.getCode())) {
			vo.setMemo("订单支付成功");
			vo.setPayStatus(HisConstants.PAY_STATUS_PAYED);
			vo.setPayedTime(result.getPayedTime());
			vo.setPayType(result.getPayType());
			vo.setStatus(orderStatus);
			vo.setAgtOrdNum(result.getPaySerilNo());
			vo.setTotalRealFee(result.getTotalRealPay());

			// 1-自费 2-全医保 3-医保+自费
			if (result.getMedicalFlag() != null && result.getMedicalFlag() != 1) {
				vo.setMedicareFee(result.getMedicareFee());
				vo.setSelfFee(result.getSelfFee());
				vo.setMedicalFlag(vo.getMedicalFlag()); // 医保
			}
		} else {
			vo.setMemo(result.getMsg());
			vo.setPayStatus(HisConstants.PAY_STATUS_NOT_PAY);
		}
		vo.setOperator(null);
		vo.setOperatorRole(null);
		return vo;
	}

	/**
	 * 是否可以继续支付
	 * 
	 * @param orderId
	 * @param orderType
	 * @param totalFee
	 * @return
	 */
	public Boolean canPay(Long orderId, String orderType, Integer totalFee) {
		logger.info("判断订单是否可支付, orderId:{}, orderType:{}, totalFee:{}", orderId, orderType, totalFee);
		Integer orderTotalFee = 0;
		Integer payStatus = 0;
		// 门诊订单
		if (HisConstants.BIZ_TYPE_OUTPATIENT.equals(orderType)) {
			HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(orderId);
			if (order == null) {
				logger.error("找不到对应的订单信息, orderId:{}, orderType:{}", orderId, orderType);
				throw new HisException(HisException.INVALIDATE_DATE_ERROR, "找不到对应的订单信息");
			}
			orderTotalFee = order.getTotalFee();
			payStatus = order.getPayStatus();
		}
		if (HisConstants.PAY_STATUS_PAYED.equals(payStatus)) {
			logger.error("订单已支付，无需再次支付, orderId:{}, orderType:{}", orderId, orderType);
			throw new HisException(HisException.INVALIDATE_DATE_ERROR, "订单已支付，无需再次支付");
		}
		if (!orderTotalFee.equals(totalFee)) {
			logger.error("支付金额不正确，订单金额：{}， 支付单金额：{}", orderTotalFee, totalFee);
			throw new HisException(HisException.INVALIDATE_DATE_ERROR, "支付金额不正确");
		}

		return true;
	}

	/**
	 * 生成门诊订单
	 * 
	 * @param params
	 * @return
	 */
	public HisOppayOrder generatorOppayOrder(OppayParamsVo params) {
		logger.info("创建门诊待支付订单：{}", JSONObject.toJSONString(params));
		try {
			if (!params.getPlatformSource().equals(CommonConstants.PLATFORM_SOURCE_WITONPAY)) {
				if (params == null || params.getPlatformSource() == null
						|| (params.getPlatformId() == null && params.getHisId() == null)
						|| StringUtils.isEmpty(params.getPatCardNo()) || StringUtils.isEmpty(params.getPatientName())
						|| StringUtils.isBlank(params.getHisOrderNo())) {
					logger.error("创建门诊待支付订单参数不能为空");
					throw new HisException(HisException.INVALIDATE_DATE_ERROR, "参数异常");
				}
				HisOppayOrder oppayOrder = generatorOppayOrderForNormal(params);
				return oppayOrder;
			} else {
				if (params == null || params.getPlatformSource() == null
						|| StringUtils.isBlank(params.getHisOrderNo())) {
					logger.error("创建门诊待支付订单参数不能为空");
					throw new HisException(HisException.INVALIDATE_DATE_ERROR, "参数异常");
				}
				HisOppayOrder oppayOrder = generatorOppayOrderForWiton(params);
				return oppayOrder;
			}
		} catch (BizException e) {
			throw e;
		} catch (Throwable e) {
			logger.error("创建门诊待支付订单异常", e);
			throw new HisException(HisException.REGISTER_UNKNOWN_ERROR, "创建门诊待支付订单异常");
		}
	}

	private HisOppayOrder generatorOppayOrderForWiton(OppayParamsVo params) {
		logger.info("开始创建门诊订单：{}", JSONObject.toJSONString(params));
		Long orderId = 0L;
		Long currTime = System.currentTimeMillis();
		HisOppayOrder opOrder = null;
		try {
			boolean beOk = sharedLockService.getShareLock(CommonConstants.GENERATOR_HIS_SYNC_KEY,
					params.getHisOrderNo());
			if (!beOk) {
				throw new HisException(HisException.INVALIDATE_SYNC_LOCK, "不能重复提交");
			}
			// 校验平台id
			if (!CommonConstants.PLATFORM_SOURCE_WITONPAY.equals(params.getPlatformSource())) {
				logger.error("sequence:{}, 输入的平台来源不合法");
				throw new HisException(HisException.PARAMS_INVALIDATE_ERROR, "输入的平台来源不合法");
			}
			// 校验医院所属平台platformId
			HospitalHis his = hospitalHisMapper.selectByPrimaryKey(params.getHisId());
			if (his == null) {
				logger.error("获取不到医院信息， id：{}", params.getHisId());
				throw new HisException(HisException.INVALIDATE_DATE_ERROR, "获取不到医院信息");
			}
			// 获取订单
			long loadTime = System.currentTimeMillis();
			HisOppayOrderVo hisOrder = null;
			Map<String, Object> map = new HashMap<>();
			if (params.getExtProps() != null) {
				map = params.getExtProps();
			}
			try {
				map.put("patientName", params.getPatientName());
				map.put("patCardNo", params.getPatCardNo());
				map.put("hisOrderNo", params.getHisOrderNo());
				OppayOrdersParamVo paramsVo = new OppayOrdersParamVo();
				paramsVo.setHisId(params.getHisId());
				paramsVo.setExtProps(map);
				if (hisliteEnvMock) {
					hisOrder = lhrmLoaderOppayStub.checkOppayOrderMock(paramsVo);
				}
				else {
					hisOrder = lhrmLoaderOppayStub.checkOppayOrder(paramsVo);
				}
				logger.info("门诊缴费信息检查返回：{}", JSONObject.toJSONString(hisOrder));
			} catch (Exception e) {
				logger.error("调用loaderOppayFacade.checkOppayOrder接口异常：{}", JSONObject.toJSONString(params), e);
				throw new HisException(HisException.DEFAULT_CODE, "调用远程接口异常");
			}
			if (System.currentTimeMillis() - loadTime > 2000) {
				logger.info(" 获取远程医院门诊待支付订单信息费时：{}", System.currentTimeMillis() - currTime);
			}
			if (hisOrder == null) {
				logger.error("获取不到对应的门诊订单：{}", JSONObject.toJSONString(params));
				throw new HisException(HisException.INVALIDATE_DATE_ERROR, "获取不到医院门诊单信息");
			}
			if (!HosConstants.RETURN_CODE_SUCCESS.equals(hisOrder.getResultCode())) {
				logger.error("获取对应的门诊订单状态错误：{}", JSONObject.toJSONString(hisOrder));
				throw new HisException(HisException.INVALIDATE_DATE_ERROR,
						hisOrder.getResultCode() + "," + hisOrder.getResultMessage());
			}
			WaitPayOrderVo payOrder = new WaitPayOrderVo();
			BeanUtils.copyProperties(hisOrder, payOrder);
			WaitPayOrderVo order = SerializationUtils.clone(payOrder);
			if (order == null) {
				logger.error("选择待支付订单失败， hisOrderId：{}", params.getHisOrderNo());
				throw new HisException(HisException.INVALIDATE_DATE_ERROR, "选择待支付订单失败");
			}
			opOrder = createOpOrder(order, params);
			if (hisOrder.getExtFields() != null) {
				opOrder.setExtFields(JSONObject.toJSONString(hisOrder.getExtFields()));// 扩展字段属性
			}

			opOrder.setHisName(his.getName());
			opOrder.setUserId(0l);
			opOrder.setHisBillNo(hisOrder.getPatHisNo());
			opOrder.setPatientName(map.get("patientName") == null ? "" : map.get("patientName").toString());
			// OrderLog log = createOrderLog(opOrder.getOppayOrderId(), params.getUserId(),
			// "创建门诊缴费订单", null, null);
			// orderPersistent.insertOppayOrder(opOrder, null);
			hisOppayOrderMapper.insertSelective(opOrder);
			return opOrder;
		} catch (Exception e) {
			logger.error("创建门诊订单失败,opOrder:{} ", JSON.toJSON(opOrder), e);
			throw e;
		} finally {
			logger.info("创建门诊订单结束， userId：{}, orderId:{}， 耗时：{}", params.getUserId(), orderId,
					System.currentTimeMillis() - currTime);
			sharedLockService.realseShareLock(CommonConstants.GENERATOR_HIS_SYNC_KEY, params.getHisOrderNo());
		}
	}

	private HisOppayOrder createOpOrder(WaitPayOrderVo wOrder, OppayParamsVo params) {
		HisOppayOrder order = new HisOppayOrder();
		order.setPlatformId(params.getPlatformId());
		order.setPlatformSource(params.getPlatformSource());
		order.setDeptId(wOrder.getDeptId());
		order.setHisOrderTime(wOrder.getHisOrderTime());
		order.setDeptName(wOrder.getDeptName());
		order.setDevId(params.getDevId());
		order.setDoctorId(wOrder.getDoctorId());
		order.setDoctorName(wOrder.getDoctorName());
		Object temp;
		if (params.getExtProps() != null) {
			temp = params.getExtProps().get("patCardNo");
			if (temp != null) {
				order.setPatCardNo(String.valueOf(temp));
			}
			temp = params.getExtProps().get("patCardType");
			if (temp != null) {
				order.setPatCardType(temp.toString());
			}
		} else {
			order.setPatCardNo(params.getPatCardNo());
			order.setPatCardType(params.getPatCardType());
		}
		order.setHisId(params.getHisId());
		order.setHisOrderNo(wOrder.getHisOrderNo());
		order.setHisSerialNo(wOrder.getHisSerilNo());
		order.setExtFields(wOrder.getExtFields());
		order.setMedicalFee(wOrder.getMedicalFee());
		order.setMedRegisterNo(wOrder.getMedRegisterNo());
		order.setName(StringUtils.isBlank(wOrder.getName()) ? "门诊缴费" : wOrder.getName());
		order.setGuideInfo(wOrder.getGuideInfo());
		order.setChargeType(wOrder.getChargeType());
		order.setPrescriptionType(wOrder.getPrescriptionType());
		if (params.getExtProps() != null) {
			temp = params.getExtProps().get("patHisNo");
			if (temp != null) {
				order.setPatHisNo(temp.toString());
			}
			temp = params.getExtProps().get("patientName");
			if (temp != null) {
				order.setPatientName(temp.toString());
			}
		} else {
			order.setPatHisNo(params.getPatHisNo());
			order.setPatientName(params.getPatientName());
		}
		order.setSelfFee(wOrder.getSelfFee());
		order.setStatus(HisConstants.OPPAY_STATUS_INIT);
		order.setTotalFee(wOrder.getTotalFee());
		if (wOrder.getTotalRealFee() != null) {
			order.setTotalRealFee(wOrder.getTotalRealFee());
		} else {
			order.setTotalRealFee(wOrder.getTotalFee());// 为空则使用总金额
		}
		order.setUserId(params.getUserId());
		order.setHisBillNo(wOrder.getHisBillNo());
		order.setMedicalFlag(wOrder.getMedicalFlag());
		order.setMedicalParam(wOrder.getMedicalParam()); // 医保支付参数
		// List<WaitPayOrderItemVo> items = wOrder.getItemList();
		// if (items != null && !items.isEmpty()) {
		// order.setItems(new ArrayList<OppayItem>(items.size()));
		// createOrderItems(order.getId(), order, items);
		// }
		return order;
	}

	private HisOppayOrder generatorOppayOrderForNormal(OppayParamsVo params) {
		throw new HisException(HisException.BUSINESS_ERROR_CODE, "暂时只支持隆回支付");
	}

	public HisOppayOrder getOppayOrderByHisOrderNo(String hisOrderNo) {
		return hisOppayOrderMapper.getOppayOrderByHisOrderNo(hisOrderNo);
	}

	public HisOppayOrder getOppayOrder(Long orderId, String tradeNo) {
		HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(orderId);
		if (order == null) {
			logger.error("sequence:{}, 支付的订单不存在：{}", JSONObject.toJSONString(order));
			throw new HisException(HisException.INVALIDATE_DATE_ERROR, "支付的订单不存在");
		}
		// 已支付订单，报异常信息
		if (HisConstants.PAY_STATUS_PAYED.equals(order.getPayStatus())) {
			logger.error("业务订单{}已经是支付状态，无法改变支付状态", order.getOppayOrderId());
			return order;
		}

		// 查询医院订单状态
		qryOppayOrderStatus(orderId, tradeNo);
		order = hisOppayOrderMapper.selectByPrimaryKey(orderId);
		return order;
	}

	private void qryOppayOrderStatus(Long orderId, String tradeNo) {
		HisOppayOrder order = hisOppayOrderMapper.selectByPrimaryKey(orderId);
		logger.info("订单：{}异步发送门诊支付订单信息", order.getOppayOrderId());
		String key = "qryOppayOrderStatus" + order.getOppayOrderId();
		try {
			Boolean ok = sharedLockService.getShareLock(CommonConstants.GENERATOR_HIS_SYNC_KEY, key);
			if (!ok) {
				logger.info("该订单已经被其他请求锁住，orderId:{},取消重发操作", order.getOppayOrderId());
				return ;
			}
			if (HisConstants.PAY_STATUS_PAYED.equals(order.getPayStatus())) {
				logger.warn("订单状态不属于支付状态，无需去发送订单");
				return ;
			}
			try {
				logger.info("到医院查询订单状态：orderId：{}", order.getOppayOrderId());
				long currTime = System.currentTimeMillis();
				Map<String, Object> extProps = new HashMap<>();
				extProps.put("tradeNo", tradeNo);
				OppayOrdersParamVo paramsVo = new OppayOrdersParamVo();
				paramsVo.setHisId(order.getHisId());
				paramsVo.setExtProps(extProps);
				QryOppayOrderStatusResultVo result = null;
				if (hisliteEnvMock) {
					result = lhrmLoaderOppayStub.qryOppayOrderStatusMock(paramsVo);
				}
				else {
					result = lhrmLoaderOppayStub.qryOppayOrderStatus(paramsVo);
				}
				if (System.currentTimeMillis() - currTime > 2000) {
					logger.info("到医院查询订单状态费时：", System.currentTimeMillis() - currTime);
				}
				logger.info("到医院查询订单状态返回数据：{}", JSONObject.toJSONString(result));
				if (HosConstants.RETURN_CODE_SUCCESS.equals(result.getResultCode())) {
					if (HosConstants.PAY_ORDER_STATUS_PAYED.equals(result.getOrderStatus())) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						PayResultVo payResultVo = new PayResultVo();
						payResultVo.setCode(HisConstants.REMOTE_HIS_SUCCESS_CODE);
						payResultVo.setOrderId(orderId);
						payResultVo.setOrderType(HisConstants.BIZ_TYPE_OUTPATIENT);
						payResultVo.setPaySerilNo(result.getTradeNo());
						payResultVo.setPayType(result.getPayType());
						payResultVo.setPayedTime(formatter.parse(result.getFeeDate()));
						payResultVo.setTotalRealPay((int)(Double.valueOf(result.getOrderAmount()).doubleValue() * 100));
						payResult(payResultVo);
						return ;
					}
					else {
						logger.warn("订单暂未成功支付，请稍后重试");
						return ;
					}
				} else if (StringUtils.isNotBlank(result.getResultCode()) && HisConstants.EXTENDS_RETURN_FAILURE_CODE.equals(result.getResultCode())) {
					logger.warn("医院返回结果一场，请稍后重试");
					return ;
				} else {
					throw new HisException(1, "通知医院失败，这是异常订单");
				}
			} catch (Exception e) {
				logger.error("发送订单到医院his失败：{}", JSONObject.toJSONString(order), e);
			}
		} finally {
			sharedLockService.realseShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, key);
			if (logger.isDebugEnabled()) {
				logger.debug("异步发送门诊支付订单结束");
			}
		}
	}
}
