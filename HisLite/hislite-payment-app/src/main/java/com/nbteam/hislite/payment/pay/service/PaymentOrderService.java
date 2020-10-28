package com.nbteam.hislite.payment.pay.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nbteam.hislite.common.constant.CommonConstants;
import com.nbteam.hislite.common.utils.RandomStringGenerator;
import com.nbteam.hislite.frame.service.SharedLockService;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchant;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMode;
import com.nbteam.hislite.payment.api.pay.dto.PaymentOrder;
import com.nbteam.hislite.payment.api.pay.dto.PaymentSerial;
import com.nbteam.hislite.payment.api.pay.request.PaymentOrderParam;
import com.nbteam.hislite.payment.api.pay.vo.*;
import com.nbteam.hislite.payment.pay.mapper.PaymentModeMapper;
import com.nbteam.hislite.payment.pay.mapper.PaymentOrderMapper;
import com.nbteam.hislite.payment.pay.utils.PayServiceExecutor;
import com.nbteam.hislite.payment.pay.utils.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class PaymentOrderService
{
	private static final Logger logger = LoggerFactory.getLogger(PaymentOrderService.class);

	@Autowired
	private PaymentOrderMapper paymentOrderMapper;

	@Autowired
	private SharedLockService sharedLockService;

	@Autowired
	private PaymentMerchantService paymentMerchantService;

	@Autowired
	private PaymentSerialService paymentSerialService;

	@Autowired
	private PaymentModeService paymentModeService;

	@Autowired
	private PaymentModeMapper paymentModeMapper;

	@Value("${hc.paycenter.cashierURI}")
	private String cashierURI;

    public UnifiedOrderResultVo registerPayOrder(UnifiedOrderParamVo param) {
		logger.info("登记支付订单开始：param：{}", JSONObject.toJSONString(param));
		UnifiedOrderResultVo result = new UnifiedOrderResultVo();
		result.setResultCode(PaymentConstants.RESULT_FAIL_CODE);
		String key = new StringBuffer().append(param.getBizChannel()).append(":").append(param.getBizType()).append(":")
				.append(param.getBizOrderId()).toString();

		try {
			Boolean ok = sharedLockService.getShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, key);
			if (!ok) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "不能重复提交订单");
			}
			PaymentOrder order = getPayOrderInfoByUnique(param.getBizOrderId(), param.getHisId(),
					param.getBizChannel(), param.getBizType());
			if (order == null) {
				order = new PaymentOrder();
				BeanUtils.copyProperties(param, order);
				order.setStatus(PaymentConstants.PAY_STATUS_INIT);
			}
			else {
				if (!PaymentConstants.PAY_STATUS_INIT.equals(order.getStatus())) {
					throw new PaymentException(PaymentException.DEFAULT_CODE, "当前订单不允许再次发起支付");
				}
			}
			order = generatorPayOrderInfo(param, order);
			// 收银台支付，输出收银台链接
			result.setResultCode(PaymentConstants.RESULT_SUCCESS_CODE);
			result.setPayOrderId(order.getPayOrderId());
			result.setTradeNo(order.getPrePayNo());
			result.setCashierURI(cashierURI);
		} catch (PaymentException e) {
			logger.error("登记支付订单业务异常", e);
			result.setResultMsg(e.getMsg());
		} catch (Exception e) {
			logger.error("登记支付订单异常", e);
			result.setResultMsg("登记支付订单异常");
		} finally {
			sharedLockService.realseShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, key);
			if (logger.isDebugEnabled()) {
				logger.debug("登记支付订单结束, 返回结果：result：{}", JSONObject.toJSONString(result));
			}
		}
		return result;
    }

	private PaymentOrder generatorPayOrderInfo(UnifiedOrderParamVo vo, PaymentOrder order) {
		if (order == null) {
			return null;
		}
		// 如果只是改变了支付渠道，则需要重新获取支付渠道
		if (order.getPayOrderId() != null && !vo.getPayChannel().equals(order.getPayChannel())) {
			order.setPayChannel(vo.getPayChannel());
			order.setPayMode(null);
		}

		PaymentMerchant merchant = getPaymentMerchantByOrder(order);
		if (merchant != null) {
			if (StringUtils.isNotBlank(merchant.getServiceMerchantId())) {
				order.setMerchantId(merchant.getServiceMerchantId());
			} else {
				order.setMerchantId(merchant.getMerchantId());
			}
			order.setInsideMerchantId(merchant.getInsideMerchantId());
		}

		if (order.getPayOrderId() == null) {
			return savePayOrderAndMed(order, null);
		} else {
			return updatePaymentOrder(order);
		}
	}

	private PaymentOrder savePayOrderAndMed(PaymentOrder order, Object medOrder) {
		if (order == null) {
			return null;
		}
		paymentOrderMapper.insertSelective(order);
		return order;
	}

	private PaymentOrder updatePaymentOrder(PaymentOrder order) {
		paymentOrderMapper.updateByPrimaryKeySelective(order);
		return order;
	}

	private PaymentMerchant getPaymentMerchantByOrder(PaymentOrder order) {
		PaymentMerchant merchant = null;
		if (StringUtils.isNotBlank(order.getPayMode())) {
			merchant = paymentMerchantService.getMerchantInfoByHisCondition(order.getHisId(), order.getBizType(),
					order.getBizChannel(), order.getPayMode());
		} else if (StringUtils.isNotBlank(order.getPayChannel()) && StringUtils.isNotBlank(order.getPayMethod())) {
			merchant = paymentMerchantService.getMerchantInfoByHisCondition(order.getHisId(), order.getBizType(),
					order.getBizChannel(), order.getPayChannel(), order.getPayMethod());
		}
		return merchant;
	}

	private PaymentOrder getPayOrderInfoByUnique(Long bizOrderId, Long hisId, String bizChannel, String bizType) {
		PaymentOrderParam paramVo = new PaymentOrderParam();
		paramVo.setHisId(hisId);
		paramVo.setBizChannel(bizChannel);
		paramVo.setBizOrderId(bizOrderId);
		paramVo.setBizType(bizType);
		List<PaymentOrder> orderList = paymentOrderMapper.getPayOrders(paramVo);
		if (!CollectionUtils.isEmpty(orderList) && orderList.size() == 1) {
			return orderList.get(0);
		}
		return null;
    }

	public UnifiedOrderResultVo qrPayUnifiedOrder(UnifiedOrderParamVo vo) {
		logger.info("登记扫码支付统一下单接口开始：param：{}", JSONObject.toJSONString(vo));
		// 开始登记订单
		UnifiedOrderResultVo result = registerPayOrder(vo);
		if (!PaymentConstants.RESULT_SUCCESS_CODE.equals(result.getResultCode())) {
			return result;
		}
		try {
			if (!PaymentConstants.PAY_METHOD_QR.equals(vo.getPayMethod())) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "接口[QrpayUnifiedOrder]不支持非扫码付业务");
			}
			PaymentOrder order = paymentOrderMapper.selectByPrimaryKey(result.getPayOrderId());
			if (order == null) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "查询不到对应的登记订单");
			}
			// 查询支付方式
			List<PaymentMode> modeList = paymentModeService.getModeInfoListByHis(order.getHisId(), order.getBizChannel(),
					order.getBizType(), vo.getPayMethod(), vo.getPayChannel());
			if (CollectionUtils.isEmpty(modeList)) {
				result.setResultCode(PaymentConstants.RESULT_FAIL_CODE);
				result.setResultMsg("医院未配置该业务的支付方式");
				return result;
			}
			result.setQrList(new ArrayList<QrResultVo>(modeList.size()));
			for (PaymentMode mode : modeList) {
				// 统一下单获取二维码
				ChooseModeParamVo qrParam = new ChooseModeParamVo();
				qrParam.setHisId(vo.getHisId());
				qrParam.setIpAddress(vo.getIpAddress());
				qrParam.setPayMode(mode.getPayMode());
				qrParam.setInsideMerchantId(order.getInsideMerchantId());
				qrParam.setPayOrderId(order.getPayOrderId());
				qrParam.setHisOrderNo(vo.getHisOrderNo());
				qrParam.setHisBillNo(vo.getHisBillNo());
				ChooseModeResultVo qrResult = chooseMode(qrParam);
				order = paymentOrderMapper.selectByPrimaryKey(result.getPayOrderId());
				result.setTradeNo(order.getPrePayNo());
				result.setResultCode(qrResult.getResultCode());
				result.setResultMsg(qrResult.getResultMsg());
				result.setCashierURI(null);
				if (PaymentConstants.RESULT_SUCCESS_CODE.equals(qrResult.getResultCode())) {
					result.getQrList().add(qrResult.getQr());
				}
			}
		} catch (PaymentException e) {
			logger.error("扫码支付统一下单异常", e);
			result.setResultMsg(e.getMsg());
		} catch (Exception e) {
			logger.error("扫码支付统一下单系统异常", e);
			result.setResultMsg("扫码支付统一下单异常");
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("扫码支付统一下单调用结束，结果：{}", JSONObject.toJSONString(result));
			}
		}
		return result;
	}

	public ChooseModeResultVo chooseMode(ChooseModeParamVo param) {
		logger.info("选择支付方式，param：{}", JSONObject.toJSONString(param));
		ChooseModeResultVo result = new ChooseModeResultVo();
		result.setResultCode(PaymentConstants.RESULT_FAIL_CODE);
		try {
			Boolean ok = sharedLockService.getShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, param.getPayOrderId());
			if (!ok) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "不能重复提交支付订单");
			}
			PaymentOrder order = getPayOrderInfoByMode(param);
			PaymentSerial serilOrder = paymentSerialService.generatorPaySerialInfo(order);
			PaySerialVo vo = new PaySerialVo();
			BeanUtils.copyProperties(serilOrder, vo);
			vo.setBody(order.getGoodsName());
			vo.setSpbillCreateIp(param.getIpAddress());
			vo.setBizType(order.getBizType());
			vo.setPlatformId(param.getPlatformId());
			vo.setHisName(order.getHisName());
			vo.setHisId(order.getHisId());
			vo.setReturnUrl(param.getReturnUrl());
			vo.setHisOrderNo(param.getHisOrderNo());
			vo.setHisBillNO(param.getHisBillNo());
			vo.setBizContent(order.getBizContent());
			vo.setPatCardNo(String.valueOf(order.getUserId()));
			vo.setPatientName(order.getChannelUserId());
			// 统一下单
			UnifiedOrderVo unionResult = unifiedOrder(vo);
			if (unionResult == null) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "统一下单异常");
			}
			PaymentSerial updateSeril = new PaymentSerial();
			updateSeril.setPaySerialId(serilOrder.getPaySerialId());
			if (PaymentConstants.RESULT_SUCCESS_CODE.equals(unionResult.getResultCode())) {
				// 修改支付流水和支付订单
				PaymentOrder updateOrder = new PaymentOrder();
				updateSeril.setPrePayNo(unionResult.getPrePayId());
				updateSeril.setMerchantId(unionResult.getMerchantId());
//				if (CommonUtil.checkIsMedPay(serilOrder.getPayMode())) {
//					updateSeril.setAcquireSerialNo(unionResult.getMedTransactionId());
//					updateSeril.setExtFields(unionResult.getPayUrl());
//					updateOrder.setAcquirerSerialNo(unionResult.getMedTransactionId());
//				}
				updateOrder.setPayOrderId(order.getPayOrderId());
				// 支付宝form表单，不保存到订单表
				updateOrder.setPrePayNo(PaymentConstants.PAY_CHANNEL_ALIPAY.equals(serilOrder.getPayChannel()) ? "" : unionResult.getPrePayId());
				updateOrder.setMerchantId(unionResult.getMerchantId());
				paymentSerialService.updatePayOrderAndSerilInfo(updateSeril, updateOrder);
			} else {
				// 调用统一下单失败后，更改流水订单状态为失败
				updateSeril.setStatus(PaymentConstants.SERIL_STATUS_FAILURE);
				paymentSerialService.update(updateSeril);
			}
			// 支付统一下单后，组装数据返回
			result.setResultCode(unionResult.getResultCode());
			result.setResultMsg(unionResult.getResultMsg());
			if (PaymentConstants.RESULT_SUCCESS_CODE.equals(result.getResultCode())) {
				result.setPayMode(serilOrder.getPayMode());
				result.setPayOrderId(param.getPayOrderId());
				if (PaymentConstants.PAY_METHOD_QR.equals(vo.getPayMethod())) {
					// 二维码支付返回二维码链接
					QrResultVo qr = new QrResultVo();
					qr.setPayChannel(vo.getPayChannel());
					qr.setQrContent(unionResult.getCodeUrl());
					result.setQr(qr);
//				} else if (PayMethodEnum.MEDICAREONLINE.getCode().equals(vo.getPayMethod())) {
//					// 医保支付返回支付链接
//					result.setPayUrl(unionResult.getPayUrl());
				} else {
					result.setPayParameter(getPayParams(vo.getPayChannel(), unionResult));
				}
			}
		} catch (PaymentException e) {
			logger.error("选择支付方式业务异常", e);
			result.setResultMsg(e.getMsg());
		} catch (Exception e) {
			logger.error("选择支付方式异常", e);
			result.setResultMsg("选择支付方式发生错误");
		} finally {
			sharedLockService.realseShareLock(CommonConstants.GENERATOR_PAYMENT_SYNC_KEY, param.getPayOrderId());
			if (logger.isDebugEnabled()) {
				logger.debug("选择支付方式调用结束，结果：{}", JSONObject.toJSONString(result));
			}
		}
		return result;
	}

	/**
	 *
	 * 获取支付参数. <br/>
	 *
	 * @author liujingcheng
	 * @date: 2017年4月10日 下午8:46:30
	 * @version 1.0
	 *
	 * @param payChannel
	 * @param unionResult
	 * @return
	 * @throws IllegalAccessException
	 */
	private JSONObject getPayParams(String payChannel, UnifiedOrderVo unionResult)
			throws IllegalAccessException {
		if (StringUtils.isBlank(payChannel)) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付渠道为空");
		}
		JSONObject payParams = null;
		switch (payChannel) {
			case PaymentConstants.PAY_CHANNEL_WEIXIN:
				Map<String, Object> payParam = new HashMap<>();
				payParam.put("appId", unionResult.getAppId());
				payParam.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000L));
				payParam.put("nonceStr", RandomStringGenerator.getRandomStringByLength(20));
				payParam.put("package", "prepay_id=" + unionResult.getPrePayId());
				payParam.put("signType", "MD5");
				payParam.put("paySign", SignUtil.getSign(payParam, unionResult.getMerchantKey()));
				payParams = (JSONObject) JSONObject.toJSON(payParam);
				break;
			case PaymentConstants.PAY_CHANNEL_ALIPAY:
				payParams = new JSONObject();
				payParams.put("form", unionResult.getPrePayId());
				break;
			default:
				break;
		}
		return payParams;
	}

	private UnifiedOrderVo unifiedOrder(PaySerialVo vo) {
		if (vo == null || StringUtils.isBlank(vo.getBody())) {
			throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "INVALID_PARAM");
		}
		IPayServiceHandler payService = getServiceByChannel(vo.getPayChannel());
		UnifiedOrderVo result = payService.unifiedOrder(vo);
		return result;
	}

	private IPayServiceHandler getServiceByChannel(String payChannel) {
		String handlerName = payChannel + "PayService";
		IPayServiceHandler payServiceHandler = PayServiceExecutor.handlerTreadMap.get(handlerName);
		if (payServiceHandler == null) {
			logger.error("bean model handler[HANDLER_NAME] not found.");
			throw new PaymentException(PaymentException.SYSTEM_ERROR_CODE, "找不到对应的服务");
		}
		return payServiceHandler;
	}

	private PaymentOrder getPayOrderInfoByMode(ChooseModeParamVo param) {
		if (StringUtils.isBlank(param.getPayMode())
				&& (StringUtils.isBlank(param.getPayMethod()) || StringUtils.isBlank(param.getPayChannel()))) {
			throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "选择的支付方式不能为空");
		}
		if (param.getPayOrderId() == null) {
			throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "选择支付方式订单不能为空");
		}
		PaymentOrder order = paymentOrderMapper.selectByPrimaryKey(param.getPayOrderId());
		if (order == null) {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "订单未登记，无法继续支付");
		}
		// 判断订单状态
		if (!PaymentConstants.PAY_STATUS_INIT.equals(order.getStatus())) {
			logger.error("当前支付状态[{}]不允许再次提交支付", order.getStatus());
			throw new PaymentException(PaymentException.DEFAULT_CODE, "当前支付状态不允许再次支付");
		}
		// 判断当前是否只能医保支付
		if (Objects.equals(order.getIsMedPay(), PaymentConstants.YES)) {
			throw new PaymentException(PaymentException.MED_BIZ_ERROR, "暂时不支持医保支付方式");
		}

		String payMode = param.getPayMode();
		if (StringUtils.isNotBlank(payMode)) {
			if (StringUtils.isBlank(param.getPayChannel()) && StringUtils.isBlank(param.getPayMethod())) {
				PaymentMode mode = paymentModeMapper.selectByPrimaryKey(param.getPayMode());
				if (mode == null) {
					throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式不存在");
				}
				order.setPayChannel(mode.getPayChannel());
				order.setPayMethod(mode.getPayMethod());
			} else {
				order.setPayChannel(param.getPayChannel());
				order.setPayMethod(param.getPayMethod());
			}
		} else if (StringUtils.isNotBlank(param.getPayChannel()) && StringUtils.isNotBlank(param.getPayMethod())) {
			if (StringUtils.isBlank(param.getPayMode())) {
				PaymentMode mode = paymentModeService.getPaymentModeByChannel(param.getPayChannel(), param.getPayMethod());
				if (mode == null) {
					throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式不存在");
				}
				payMode = mode.getPayMode();
			} else {
				payMode = param.getPayMode();
			}
			order.setPayChannel(param.getPayChannel());
			order.setPayMethod(param.getPayMethod());
		} else {
			throw new PaymentException(PaymentException.DEFAULT_CODE, "支付方式异常");
		}

		order.setPayMode(payMode);
		if (param.getInsideMerchantId() == null) {
			PaymentMerchant merchant = getPaymentMerchantByOrder(order);
			if (merchant == null) {
				throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "找不到对应的支付方式m2m");
			}
			if (StringUtils.isNotBlank(merchant.getServiceMerchantId())) {
				order.setMerchantId(merchant.getServiceMerchantId());
			} else {
				order.setMerchantId(merchant.getMerchantId());
			}
			order.setInsideMerchantId(merchant.getInsideMerchantId());
		} else {
			order.setInsideMerchantId(param.getInsideMerchantId());
		}
		return order;
	}

	public int update(PaymentOrder updateOrder) {
		return paymentOrderMapper.updateByPrimaryKeySelective(updateOrder);
	}

	public ClosePayOrderVo closePayOrder(PaySerialVo vo) {
		if (logger.isDebugEnabled()) {
			logger.debug("开始关闭订单", JSON.toJSONString(vo));
		}
		if (vo == null || vo.getMerchantOrderId() == null) {
			throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "INVALID_PARAM");
		}
		IPayServiceHandler payService = getServiceByChannel(vo.getPayChannel());
		ClosePayOrderVo result = payService.closePayOrder(vo);
		return result;
	}
}
