package com.nbteam.hislite.payment.pay.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.nbteam.hislite.common.utils.DateUtils;
import com.nbteam.hislite.common.utils.MapTool;
import com.nbteam.hislite.common.utils.MoneyCovert;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchant;
import com.nbteam.hislite.payment.api.pay.vo.*;
import com.nbteam.hislite.payment.api.exception.PaymentException;
import com.nbteam.hislite.payment.pay.mapper.PaymentMerchantMapper;
import com.nbteam.hislite.payment.pay.utils.PayServiceHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
@PayServiceHandler(name="alipayPayService")
public class AlipayPayService extends IPayServiceHandler
{
	private static final Logger logger = LoggerFactory.getLogger(AlipayPayService.class);

	@Value("${alipay.pay.notify.url}")
	private String ZFB_NOTIFY_URL;

	@Autowired
	private PaymentMerchantMapper paymentMerchantMapper;

//	@Override
//	public PayQueryVo orderQuery(PaySerialVo vo) {
//		logger.info("当面付alipayServiceImpl.orderQuery{}", JSON.toJSONString(vo));
//		try {
//			MerchantInfo merchant = getMerchantInfoByKey(vo.getInsideMerchantId(), context);
//			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
//					merchant.getPublicKey()); // 获得初始化的AlipayClient
//
//			// 使用SDK，构建单发请求模型
//			AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//			Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getMerchantOrderId());
//			request.setBizContent(JSON.toJSONString(map));
//			logger.info("sequence:{}, 支付宝交易查询接口请求数据：{}", context.getMsgSeq(), JSON.toJSONString(map));
//			// 使用SDK，调用交易查询接口
//			AlipayTradeQueryResponse response = alipayClient.execute(request);
//			logger.info("sequence:{}, 支付宝交易查询接口返回结果：{}", context.getMsgSeq(), response.getBody());
//
//			String code = AlipayResultCodeEnum.getStatusValue(response.getCode());
//			String msgCode;
//			if (!code.equals(PaymentConstants.RESULT_SUCCESS_CODE)) {
//				msgCode = PaymentConstants.RESULT_FAIL_CODE;
//			} else {
//				String tradeStatus = response.getTradeStatus();
//				msgCode = PayStatusSwitchUtil.AlipayResultSwitch(tradeStatus);
//			}
//
//			PayQueryVo resultVo = new PayQueryVo();
//			resultVo.setResultCode(msgCode);
//			resultVo.setResultMsg(response.getSubMsg());
//			resultVo.setAcquireSerialNo(response.getTradeNo());
//			resultVo.setOpenId(response.getBuyerUserId());
//			resultVo.setBuyerAlipayAccount(response.getBuyerLogonId());
//			if (StringUtils.isNotBlank(response.getTotalAmount())) {
//				resultVo.setTotalFee((int) MathUtils.mul(Double.parseDouble(response.getTotalAmount()), 100));
//			}
//			resultVo.setPayedTime(response.getSendPayDate());
//			return resultVo;
//		} catch (AlipayApiException e) {
//			logger.error("sequence:{}, 调用支付宝交易查询接口异常", context.getMsgSeq(), e);
//			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用支付宝交易查询接口异常" + e.getMessage());
//		}
//	}

//	@Override
//	public F2FRevokeVo revoke(PaySerialVo vo) {
//		logger.info("当面付alipayServiceImpl.revoke{}", JSON.toJSONString(vo));
//		try {
//			MerchantInfo merchant = getMerchantInfoByKey(vo.getInsideMerchantId(), context);
//			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
//					merchant.getPublicKey()); // 获得初始化的AlipayClient
//
//			// 使用SDK，构建单发请求模型
//			AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
//
//			Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getMerchantOrderId());
//			request.setBizContent(JSON.toJSONString(map));
//			logger.info("sequence:{}, 发送统一收单交易撤销接口参数：{}", context.getMsgSeq(), JSON.toJSONString(map));
//			// 使用SDK，调用单发接口发送纯文本消息
//			AlipayTradeCancelResponse response = alipayClient.execute(request);
//			logger.info("sequence:{}, 发送统一收单交易撤销接口返回结果：{}", context.getMsgSeq(), response.getBody());
//			String code = response.getCode();
//			String msgCode = AlipayResultCodeEnum.getStatusValue(code);
//			String payStatus = AlipayResultCodeEnum.getStatusValue(code);
//			F2FRevokeVo resultVo = new F2FRevokeVo();
//			resultVo.setResultCode(msgCode);
//			resultVo.setRevokeStatus(payStatus);
//			resultVo.setResultMsg(response.getSubMsg());
//			return resultVo;
//		} catch (AlipayApiException e) {
//			logger.error("sequence:{}, 调用统一收单交易撤销接口异常", context.getMsgSeq(), e);
//			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用统一收单交易撤销接口异常" + e.getMessage());
//		}
//	}

	@Override
	public UnifiedOrderVo unifiedOrder(PaySerialVo vo) {
		logger.info("支付宝统一下单alipayServiceImpl.unifiedOrder{}", JSON.toJSONString(vo));
		UnifiedOrderVo result = new UnifiedOrderVo();
		result.setResultCode(PaymentConstants.RESULT_FAIL_CODE);
		try {
			if (StringUtils.isBlank(vo.getMerchantOrderId())) {
				throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "商户订单号不能为空");
			}
			if (vo.getTotalFee() == null || vo.getTotalFee() < 1) {
				throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "支付金额不合法");
			}
			if (StringUtils.isBlank(vo.getBody())) {
				throw new PaymentException(PaymentException.WX_PARAM_ERROR_ERROR_CODE, "body内容不能为空");
			}
			if (PaymentConstants.PAY_METHOD_QR.equals(vo.getPayMethod())) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "暂不支持扫码线下支付");
			}
			PaymentMerchant merchant = paymentMerchantMapper.selectByPrimaryKey(vo.getInsideMerchantId());
			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
					merchant.getPublicKey()); // 获得初始化的AlipayClient

			// 拼接请求参数
			String bizContent = createUnifiedContent(vo, merchant.getSwitchs());
			logger.info("发送支付宝wap支付订单参数：{}", bizContent);

			AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的request
			alipayRequest.setReturnUrl(vo.getReturnUrl());
			alipayRequest.setNotifyUrl(ZFB_NOTIFY_URL); // 在公共参数中设置回跳和通知地址
			alipayRequest.setBizContent(bizContent); // 填充业务参数
			String form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			logger.info("发送支付宝wap支付订单返回结果：{}", form);
			if (StringUtils.isBlank(form)) {
				throw new PaymentException(PaymentException.DEFAULT_CODE, "支付宝统一下单异常");
			}
			result.setResultCode(PaymentConstants.RESULT_SUCCESS_CODE);
			result.setMerchantId(merchant.getMerchantId());
			result.setPrePayId(form);
			result.setMerchantId(merchant.getMerchantId());
			return result;
		} catch (Exception e) {
			logger.error("调用支付宝wap支付订单接口异常", e);
			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用支付宝wap支付订单接口异常" + e.getMessage());
		}
	}

//	@Override
//	public RefundResultVo refundOrder(RefundOrderInfoVo vo) {
//		logger.info("sequece:{},  当面付alipayServiceImpl.refundOrder{}", context.getMsgSeq(), JSON.toJSONString(vo));
//		try {
//			MerchantInfo merchant = getMerchantInfoByKey(vo.getInsideMerchantId(), context);
//			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
//					merchant.getPublicKey()); // 获得初始化的AlipayClient
//
//			// 使用SDK，构建单发请求模型
//			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
//			// 拼装请求参数
//			String bizContent = createRefundContent(vo);
//			request.setBizContent(bizContent);
//			logger.info("sequence:{}, 支付宝交易退款接口请求数据：{}", context.getMsgSeq(), bizContent);
//			// 使用SDK，调用交易退款接口
//			AlipayTradeRefundResponse response = alipayClient.execute(request);
//			logger.info("sequence:{}, 支付宝交易退款接口返回结果：{}", context.getMsgSeq(), JSONObject.toJSONString(response));
//			String code = response.getCode();
//			String msgCode = AlipayResultCodeEnum.getStatusValue(code);
//			RefundResultVo resultVo = new RefundResultVo();
//			resultVo.setResultCode(msgCode);
//			resultVo.setResultMsg(response.getSubMsg());
//			resultVo.setRefundNo(response.getTradeNo());
//			resultVo.setOpenId(response.getOpenId());
//			resultVo.setUnionId(response.getBuyerUserId());
//			resultVo.setPayAccount(response.getBuyerLogonId());
//			if (StringUtils.isNoneBlank(response.getRefundFee())) {
//				resultVo.setRefundFee((int) MathUtils.mul(Double.parseDouble(response.getRefundFee()), 100));
//			}
//			resultVo.setRefundTime(response.getGmtRefundPay());
//			return resultVo;
//		} catch (AlipayApiException e) {
//			logger.error("sequence:{}, 调用支付宝交易退款接口异常", context.getMsgSeq(), e);
//			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用支付宝交易退款接口异常" + e.getMessage());
//		}
//	}



//	@Override
//	public RefundOrderCheckVo checkRefundOrderStatus(RefundOrderInfoVo vo) {
//		logger.info("sequece:{},  查询退款订单alipayServiceImpl.checkRefundOrderStatus{}", context.getMsgSeq(), JSON.toJSONString(vo));
//		try {
//			MerchantInfo merchant = getMerchantInfoByKey(vo.getInsideMerchantId(), context);
//			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
//					merchant.getPublicKey()); // 获得初始化的AlipayClient
//
//			// 使用SDK，构建单发请求模型
//			AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
//			// 拼装请求参数
//			String bizContent = createRefundQueryContent(vo);
//			request.setBizContent(bizContent);
//			logger.info("sequence:{}, 支付宝交易退款查询接口请求数据：{}", context.getMsgSeq(), bizContent);
//			// 使用SDK，调用交易退款接口
//			AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
//			logger.info("sequence:{}, 支付宝交易退款查询接口返回结果：{}", context.getMsgSeq(), JSONObject.toJSONString(response));
//			String msgCode;
//			RefundOrderCheckVo resultVo = new RefundOrderCheckVo();
//			if (StringUtils.isBlank(response.getOutRequestNo())) {
//				msgCode = PaymentConstants.RESULT_FAIL_CODE;
//			} else {
//				msgCode = PaymentConstants.RESULT_SUCCESS_CODE;
//			}
//			resultVo.setResultCode(msgCode);
//			resultVo.setResultMsg(response.getSubMsg());
//			resultVo.setRefundOrderId(MathUtils.replaceLong(response.getOutRequestNo()));
//			if (StringUtils.isNoneBlank(response.getRefundAmount())) {
//				resultVo.setRefundTotalFee(MoneyCovert.covertFenMoney(response.getRefundAmount()));
//				resultVo.setRealRefundFee(resultVo.getRefundTotalFee());
//			}
//			resultVo.setAcquireSerialNo(response.getTradeNo());
//			resultVo.setMerchantOrderId(response.getOutTradeNo());
//			resultVo.setReason(response.getRefundReason());
//			return resultVo;
//		} catch (AlipayApiException e) {
//			logger.error("sequence:{}, 调用支付宝交易退款查询接口异常", context.getMsgSeq(), e);
//			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用支付宝交易退款查询接口异常" + e.getMessage());
//		}
//	}

	@Override
	public ClosePayOrderVo closePayOrder(PaySerialVo vo) {
		logger.info("订单关闭alipayServiceImpl.revoke{}", JSON.toJSONString(vo));
		try {
			PaymentMerchant merchant = paymentMerchantMapper.selectByPrimaryKey(vo.getInsideMerchantId());
			AlipayClient alipayClient = getDefaultAlipayClient(merchant.getAppId(), merchant.getPrivateKey(),
					merchant.getPublicKey()); // 获得初始化的AlipayClient

			// 使用SDK，构建单发请求模型
			AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();

			Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getMerchantOrderId());
			request.setBizContent(JSON.toJSONString(map));
			logger.info("发送交易关闭接口参数：{}", JSON.toJSONString(map));
			// 使用SDK，调用单发接口发送纯文本消息
			AlipayTradeCloseResponse response = alipayClient.execute(request);
			logger.info("sequence:{}, 发送交易关闭接口返回结果：{}", response.getBody());
			String code = response.getCode();
			String msgCode = code;
			if (!msgCode.equals(PaymentConstants.ALIPAY_RESULT_SUCCESS)) {
				msgCode = PaymentConstants.RESULT_FAIL_CODE;
			}
			ClosePayOrderVo resultVo = new ClosePayOrderVo();
			resultVo.setResultCode(msgCode);
			resultVo.setResultMsg(response.getSubMsg());
			return resultVo;
		} catch (AlipayApiException e) {
			logger.error("调用交易关闭接口异常", e);
			throw new PaymentException(PaymentException.DEFAULT_CODE, "调用交易关闭接口异常" + e.getMessage());
		}
	}

	private AlipayClient getDefaultAlipayClient(String appId, String privateKey, String publicKey) {
		return new DefaultAlipayClient(PaymentConstants.APLIPAY_GATEWAY, appId, privateKey, PaymentConstants.APLIPAY_DEFAULT_FROMAT,
				PaymentConstants.DEFAULT_CHARSET, publicKey, PaymentConstants.APLIPAY_SIGNTYPEV1);
	}

//	/**
//	 *
//	 * 创建扫码支付订单content
//	 *
//	 * @author dingqi
//	 * @date: 2017年3月15日 上午12:20:28
//	 * @version 1.0
//	 *
//	 * @param vo
//	 * @return
//	 */
//	private String createMicroPayContent(PaySerialVo vo) {
//		Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getMerchantOrderId(), "total_amount",
//				MathUtils.div(vo.getTotalFee(), 100.00), "subject", vo.getBody(), "scene", vo.getScene(), "auth_code",
//				vo.getAuthCode(), "operator_id", vo.getOperatorId(), "store_id", vo.getStoreId(), "terminal_id",
//				vo.getDeviceInfo());
//
//		Date now = new Date();
//		String timeExpire = vo.getOverTime() == null || vo.getOverTime().before(now) ? "30m"
//				: DateUtils.getMinutesInterval(now, vo.getOverTime()) + "m";
//		map.put("timeout_express", timeExpire);
//		Map<String, Object> map2 = MapTool.getSOMap("sys_service_provider_id", getServiceId(vo));
//		map.put("extend_params", JSON.toJSON(map2));
//
//		return JSON.toJSONString(map);
//	}

	/**
	 *
	 * 退款
	 *
	 * @author dingqi
	 * @date: 2017年3月15日 上午1:39:46
	 * @version 1.0
	 *
	 * @param vo
	 * @return
	 */
//	private String createRefundContent(RefundOrderInfoVo vo) {
//		Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getPaySerialId(), "refund_amount",
//				MathUtils.div(vo.getRefundFee(), 100.00), "trade_no", vo.getAcquirerSerialNo(), "out_request_no",
//				vo.getRefundOrderId(), "store_id", vo.getStoreId(), "terminal_id", vo.getTerminalId());
//
//		if (StringUtils.isBlank(vo.getReason())) {
//			map.put("refund_reason", "no_reason");
//		} else {
//			map.put("refund_reason", vo.getReason());
//		}
//		return JSON.toJSONString(map);
//	}

//	private String createRefundQueryContent(RefundOrderInfoVo vo) {
//		Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getPaySerialId(), "trade_no", vo.getAcquirerSerialNo(),
//				"out_request_no", vo.getRefundOrderId());
//
//		return JSON.toJSONString(map);
//	}

	private String createUnifiedContent(PaySerialVo vo, String switchs) {
		Date now = new Date();
		String timeExpire = vo.getOverTime() == null || vo.getOverTime().before(now) ? PaymentConstants.ALIPAY_DEFAULT_TIMEOUT
				: DateUtils.getMinutesInterval(now, vo.getOverTime()) + "m";
		Map<String, Object> map = MapTool.getSOMap("out_trade_no", vo.getMerchantOrderId(), "total_amount",
				MoneyCovert.formatToYuan(vo.getTotalFee()), "subject", vo.getBody(), "timeout_express", timeExpire,
				"product_code", "QUICK_WAP_PAY");
		// 是否禁用信用卡
//		if (checkUserCredit(switchs) != null) {
			map.put("disable_pay_channels", "creditCard");
//		}
		map.put("extend_params", String.format("{\"sys_service_provider_id\":\"%s\"}", getServiceId(vo)));
		return JSON.toJSONString(map);
	}

	private String getServiceId(PaySerialVo vo) {
//		PayConfig config = this.payConfigService.getPayConfigByCondition(vo.getHisId(), vo.getMerchantId(), "service_code",
//				new HcContext());
//		if (null != config && StringUtils.isNotBlank(config.getConfigKey())) {
//			return config.getConfigValue();
//		} else {
//			return "2088811029856671";
//		}
		return "2088811029856671";
	}
}
