package com.nbteam.hislite.lhrm.inhospital.service;

import java.util.Map;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.nbteam.hislite.common.castor.MarshallerUtil;
import com.nbteam.hislite.lhrm.api.exception.HospitalException;
import com.nbteam.hislite.lhrm.api.inhospital.vo.HisPatientExpenseVo;
import com.nbteam.hislite.lhrm.api.inhospital.vo.InHosputalHisResultVo;
import net.sf.json.xml.XMLSerializer;

/**
 * 门诊相关接口
 * 
 * @author zhouzl
 *
 */
@Service
public class InHospitalService {
	private static final Logger logger = LoggerFactory.getLogger(InHospitalService.class);

	private static final XMLSerializer SERIALIZER = new XMLSerializer();

	private final String KEY = "&key=3de4d493f22f54572d27ea055e469526";

	private final String HOSPITALID = "lhxrmyyadmin";

	private final String HisUrl = "http://220.170.195.141:3002/soap/IJhyyCal";

	/**
	 * 获取就诊人预缴住院费用
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public HisPatientExpenseVo getPatientExpense(Long hisId, Map<String, Object> extProps) {
		String patCardNo = "";
		if (null != extProps.get("patCardNo")) {
			 patCardNo = extProps.get("patCardNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "住院号不能为空");
		}
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<SERIALNUMBER>" + patCardNo + "</SERIALNUMBER>");
		builder.append("</REQUEST>");
		logger.debug("==>" + builder.toString());
		// String respXml = HttpPostXml.sendPost("HisUrl", builder.toString());
		String respXml = " <Response><result>success</result><message>成功</message><realName>张三</realName><idCard>430702199002128766</idCard><phone>18216544218</phone><sex>男</sex>"
				+ "<totleAmt>3000</totleAmt><usedAmt>2013.61</usedAmt><inpatientArea>总院</inpatientArea><departmentCode>EK02</departmentCode><doctorCode>D032L</doctorCode><remainAmt>500</remainAmt></Response>";
		logger.debug("==>" + respXml);
		MarshallerUtil marshallerUtil;
		HisPatientExpenseVo hisPatientExpenseVo;
		try {
			marshallerUtil = new MarshallerUtil("InHospitalService-getPatientExpense.xml", InHospitalService.class);
			hisPatientExpenseVo = (HisPatientExpenseVo) marshallerUtil.unMarshal(respXml);
			logger.debug("==>" + hisPatientExpenseVo.getResultCode());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误");
		}
		return hisPatientExpenseVo;
	}

	/**
	 * 预缴住院费用
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public InHosputalHisResultVo prePayExpense(Long hisId, Map<String, Object> extProps) {
		String patCardNo = "";
		String prepayaAmt = "";
		String tradeNo = "";
		String patientName = "";
		if (null != extProps.get("patCardNo")) {
			 patCardNo = extProps.get("patCardNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊卡不能为空");
		}
		if (null != extProps.get("prepayAmt")) {
			 prepayaAmt = extProps.get("prepayAmt").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "支付金额不能为空");
		}
		if (null != extProps.get("tradeNo")) {
			 tradeNo = extProps.get("tradeNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "交易订单号不能为空");
		}
		if (null != extProps.get("patientName")) {
			patientName = extProps.get("patientName").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "交易订单号不能为空");
		}
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<REALNAME>" + patientName + "</REALNAME>");
		builder.append("<PATIENTCARD>" + patCardNo + "</PAIENTCARD>");
		builder.append("<PREPAYAAMT>" + prepayaAmt + "</PREPAYAAMT>");
		builder.append("<TRADENO>" + tradeNo + "</TRADENO>");
		builder.append("</REQUEST>");
		logger.debug("请求==>" + builder.toString());
		// String respXml = HttpPostXml.sendPost("HisUrl", builder.toString());
		String respXml = " <Response><result>success</result>" + "  <message></message>"
				+ "  <invoiceNo>zy2017032</invoiceNo>" + "  <serialNo>1fa3sdf1as3df1a3</serialNo>" + "</Response>";
		logger.debug("返回==>" + respXml);
		MarshallerUtil marshallerUtil;
		InHosputalHisResultVo inHosputalHisResultVo;
		try {
			marshallerUtil = new MarshallerUtil("InHospitalService-paymentOrderNotify.xml", InHospitalService.class);
			inHosputalHisResultVo = (InHosputalHisResultVo) marshallerUtil.unMarshal(respXml);
			logger.debug("==>" + inHosputalHisResultVo.getResultCode());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误");
		}
		return inHosputalHisResultVo;
	}

	public HisPatientExpenseVo getPatientExpenseMock(Long hisId, Map<String, Object> extProps) {
		HisPatientExpenseVo hisPatientExpenseVo = new HisPatientExpenseVo();
		hisPatientExpenseVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		hisPatientExpenseVo.setPatientName("1");
		hisPatientExpenseVo.setTotleAmt("2");
		hisPatientExpenseVo.setRemainAmt("3");
		hisPatientExpenseVo.setUsedAmt("4");
		hisPatientExpenseVo.setHisNo("5");
		return hisPatientExpenseVo;
	}

	public InHosputalHisResultVo prePayExpenseMock(Long hisId, Map<String, Object> extProps) {
		InHosputalHisResultVo inHosputalHisResultVo = new InHosputalHisResultVo();
		inHosputalHisResultVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		inHosputalHisResultVo.setHisRecepitNo("1");
		inHosputalHisResultVo.setHisSerialNo("2");
		inHosputalHisResultVo.setExtFields(null);
		inHosputalHisResultVo.setGuideInfo("4");
		return inHosputalHisResultVo;
	}
}
