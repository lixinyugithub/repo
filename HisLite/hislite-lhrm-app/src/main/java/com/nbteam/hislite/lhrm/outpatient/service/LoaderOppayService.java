package com.nbteam.hislite.lhrm.outpatient.service;

import com.nbteam.hislite.common.castor.MarshallerUtil;
import com.nbteam.hislite.common.utils.MD5;
import com.nbteam.hislite.common.utils.SignatureUtils;
import com.nbteam.hislite.lhrm.api.common.constant.HosConstants;
import com.nbteam.hislite.lhrm.api.exception.HospitalException;
import com.nbteam.hislite.lhrm.api.outpatient.vo.*;
import com.nbteam.hislite.lhrm.common.WebServiceUtil;
import com.witontek.ehospital.IWindowPayWebServiceV2;
import net.sf.json.xml.XMLSerializer;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 门诊相关接口
 * 
 * @author zhouzl
 *
 */
@Service
public class LoaderOppayService {
	private static final Logger logger = LoggerFactory.getLogger(LoaderOppayService.class);

	private static final XMLSerializer SERIALIZER = new XMLSerializer();
    //测试key=3de4d493f22f54572d27ea055e469526;生产key=efae2f48d9976206346462aab1e4c1c2;
	private final String KEY = "&key=efae2f48d9976206346462aab1e4c1c2";

	private final String HOSPITALID = "lhxrmyyadmin";

	private final String HisUrl = "http://220.170.195.141:3002/soap/IJhyyCal";

	/**
	 * 就诊人信息查询
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public FindClinicNoResultVo queryPatientInfo(String patCardNo) {
		String serviceName = "queryPatientInfo";
		FindClinicNoResultVo findClinicNoResultVo = new FindClinicNoResultVo();
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<PATIENTCARD>" + patCardNo + "</PATIENTCARD>");
		builder.append("</REQUEST>");
		logger.debug("请求==>" + builder.toString());

		// String respXml = "<root>" + " <result>success</result>" + "
		// <message></message>" + " <realName>张三</realName>"
		// + " <idCard>430702199002128766</idCard>" + " <phone>134567890111</phone>" + "
		// <sex>男</sex>"
		// + " <birthday>2006-11-11</birthday>" + " <eCardBalance>203.67</eCardBalance>"
		// + " <hisNo>6000234</hisNo>" + "</root>";
		MarshallerUtil marshallerUtil;
		try {
			String respXml = WebServiceUtil.remoteGetDate(HisUrl, serviceName, builder.toString());
			logger.debug("返回==>" + respXml);

			respXml = respXml.replaceAll("<Ryinfo>", "");
			respXml = respXml.replaceAll("</Ryinfo>", "");

			marshallerUtil = new MarshallerUtil("OppayService-queryPatientInfo.xml", LoaderOppayService.class);
			findClinicNoResultVo = (FindClinicNoResultVo) marshallerUtil.unMarshal(respXml);
			if (!findClinicNoResultVo.getResultCode().equals(HosConstants.SUCCESS_CODE)) {
				throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR,
						findClinicNoResultVo.getResultMsg());
			}

			logger.debug("==>" + findClinicNoResultVo.getRealName());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误");
		}
		return findClinicNoResultVo;
	}

	/**
	 * 查询门诊号(暂时未使用到)
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public FindClinicNoResultVo getClinicNo(String patCardNo) {
		String serviceName = "findClinicNo";
		FindClinicNoResultVo findClinicNoResultVo = queryPatientInfo(patCardNo);
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<REALNAME>" + findClinicNoResultVo.getRealName() + "</REALNAME>");
		builder.append("<PATIENTCARD>" + findClinicNoResultVo.getPatientCard() + "</PATIENTCARD>");
		builder.append("</REQUEST>");
		logger.debug("请求==>" + builder.toString());

		MarshallerUtil marshallerUtil;
		try {
			String respXml = WebServiceUtil.remoteGetDate(HisUrl, serviceName, builder.toString());
			logger.debug("==>" + respXml);
			marshallerUtil = new MarshallerUtil("OppayService-getClinicNo.xml", LoaderOppayService.class);
			findClinicNoResultVo = (FindClinicNoResultVo) marshallerUtil.unMarshal(respXml);
			logger.debug("==>" + findClinicNoResultVo.getClinicNo());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误");
		}
		return findClinicNoResultVo;
	}

	/**
	 * 获取远程医院门诊待支付订单信息列表
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 * @throws Exception
	 */
	public List<HisOppayOrderVo> getHisOppayOrders(Long hisId, Map<String, Object> extProps) {
		String serviceName = "findOutpatientPay";
		String patCardNo = "";
		if (null != extProps.get("patCardNo")) {
			patCardNo = extProps.get("patCardNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊卡不能为空");
		}
		FindClinicNoResultVo findClinicNoResultVo = queryPatientInfo(patCardNo);
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<REALNAME>" + findClinicNoResultVo.getRealName() + "</REALNAME>");
		builder.append("<PATIENTCARD>" + patCardNo + "</PATIENTCARD>");
		builder.append("</REQUEST>");
		logger.debug("请求==>" + builder.toString());

		MarshallerUtil marshallerUtil = null;
		GetHisOppayOrderVo getHisOppayOrderVo = null;
		try {
			String respXml = WebServiceUtil.remoteGetDate(HisUrl, serviceName, builder.toString());
			logger.debug("==>" + respXml);
			respXml = respXml.replaceAll("<content>", "");
			respXml = respXml.replaceAll("</content>", "");
			respXml = respXml.replaceAll("\\.", "");
			marshallerUtil = new MarshallerUtil("OppayService-getHisOppayOrders.xml", LoaderOppayService.class);
			getHisOppayOrderVo = (GetHisOppayOrderVo) marshallerUtil.unMarshal(respXml);
			if (!findClinicNoResultVo.getResultCode().equals(HosConstants.SUCCESS_CODE)) {
				throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR,
						findClinicNoResultVo.getResultMsg());
			}
			logger.debug("==>" + getHisOppayOrderVo.getResultMessage());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误,请重试");
		}
		if(getHisOppayOrderVo.getItemList()==null) {
			List<HisOppayOrderVo> itemList =new ArrayList<>();
			getHisOppayOrderVo.setItemList(itemList);
				return getHisOppayOrderVo.getItemList();
		}else {			
				return getHisOppayOrderVo.getItemList();	
		}		
	}

	/**
	 * 发送门诊支付订单到医院
	 * 
	 * @param hisId
	 * @param payed
	 * @return
	 */
	public Oppayed2HisResultVo getHisOppayResult(Long hisId, Map<String, Object> payed) {
		String serviceName = "outpatientPay";
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		if (null != payed.get("prescriptionNo").toString()) {
			builder.append("<PRESCRIPTIONNO>" + payed.get("prescriptionNo").toString() + "</PRESCRIPTIONNO>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "费用单编号不能为空");
		}
		if (null != payed.get("patientName").toString()) {
			builder.append("<REALNAME>" + payed.get("patientName").toString() + "</REALNAME>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊人姓名不能为空");
		}
		if (null != payed.get("patCardNo").toString()) {
			builder.append("<PATIENTCARD>" + payed.get("patCardNo").toString() + "</PATIENTCARD>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊人卡号不能为空");
		}
		if (null != payed.get("updateDate").toString()) {
			builder.append("<UPDATEDATE>" + payed.get("updateDate").toString() + "</UPDATEDATE>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "缴费时间不能为空");
		}
		if (null != payed.get("orderFee").toString()) {
			builder.append("<ORDERFEE>" + payed.get("orderFee").toString() + "</ORDERFEE>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "缴费金额不能为空");
		}
		if (null != payed.get("feeType").toString()) {
			builder.append("<FEETYPE>" + payed.get("feeType").toString() + "</FEETYPE>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "缴费类型不能为空");
		}
		if (null != payed.get("tradeNo").toString()) {
			builder.append("<TRADENO>" + payed.get("tradeNo").toString() + "</TRADENO>");
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "商户交易订单号不能为空");
		}
		builder.append("</REQUEST>");
		// TODO 这里需要去调用医院的接口
		logger.debug("请求==>" + builder.toString());

		MarshallerUtil marshallerUtil = null;
		Oppayed2HisResultVo hisOppayOrderVo = null;
		try {
			String respXml = WebServiceUtil.remoteGetDate(HisUrl, serviceName, builder.toString());
			logger.debug("返回==>" + respXml);
			marshallerUtil = new MarshallerUtil("OppayService-paymentOrderNotify.xml", LoaderOppayService.class);
			hisOppayOrderVo = (Oppayed2HisResultVo) marshallerUtil.unMarshal(respXml);
			logger.debug("==>" + hisOppayOrderVo.getResultMsg());
			if (!hisOppayOrderVo.getResultCode().equals(HosConstants.SUCCESS_CODE)) {
				throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, hisOppayOrderVo.getResultMsg());
			}
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误");
		}
		return hisOppayOrderVo;
	}

	/**
	 * 门诊缴费信息检查
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public HisOppayOrderVo checkOppayOrder(Long hisId, Map<String, Object> extProps) {
		String serviceName = "findOutpatientPay";
		String patCardNo = "";
		String hisOrderNo = "";
		String patientName = "";
		if (null != extProps.get("patCardNo")) {
			patCardNo = extProps.get("patCardNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊卡不能为空");
		}
		if (null != extProps.get("hisOrderNo")) {
			hisOrderNo = extProps.get("hisOrderNo").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "门诊号不能为空");
		}
		if (null != extProps.get("patientName")) {
			patientName = extProps.get("patientName").toString();
		} else {
			throw new HospitalException(HospitalException.HOSCENTER_PARAM_ERROR, "就诊人姓名不能为空");
		}
		StringBuilder builder = new StringBuilder();
		builder.append("<REQUEST>");
		builder.append("<REALNAME>" + patientName + "</REALNAME>");
		builder.append("<PATIENTCARD>" + patCardNo + "</PATIENTCARD>");
		builder.append("</REQUEST>");
		logger.debug("请求==>" + builder.toString());

		MarshallerUtil marshallerUtil = null;
		GetHisOppayOrderVo getHisOppayOrderVo = null;
		try {
			String respXml = WebServiceUtil.remoteGetDate(HisUrl, serviceName, builder.toString());
			logger.debug("返回==>" + respXml);
			respXml = respXml.replaceAll("<content>", "");
			respXml = respXml.replaceAll("</content>", "");
			respXml = respXml.replaceAll("\\.", "");
			marshallerUtil = new MarshallerUtil("OppayService-getHisOppayOrders.xml", LoaderOppayService.class);
			getHisOppayOrderVo = (GetHisOppayOrderVo) marshallerUtil.unMarshal(respXml);
			logger.debug("==>" + getHisOppayOrderVo.getResultMessage());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误,请重试");
		}
		if (getHisOppayOrderVo.getResultCode().equals(HosConstants.SUCCESS_CODE)) {
			List<HisOppayOrderVo> oppayList = getHisOppayOrderVo.getItemList();
			for (int i = 0; i < oppayList.size(); i++) {// 内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
				if (hisOrderNo.equals(oppayList.get(i).getHisOrderNo())) {
					oppayList.get(i).setResultCode("0");
					oppayList.get(i).setResultMessage("成功");
					return oppayList.get(i);
				}
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public CreateOppayOrderResultVo createOppayOrder(Long hisId, Map<String, Object> extProps) {
		StringBuilder builder = new StringBuilder();
		builder.append("<request>");
		builder.append("<hospital_id>" + HOSPITALID + "</hospital_id>");
		if (extProps.get("totAmt") != null) {
			double totalAmt = Double.valueOf(extProps.get("totAmt").toString());
			totalAmt = totalAmt / 100;
			builder.append("<totle_amt>" + totalAmt + "</totle_amt>");
			extProps.put("totle_amt", totalAmt);
			extProps.remove("totAmt");
		}
		if (extProps.get("patHisNo") != null) {
			builder.append("<visit_id>" + extProps.get("patHisNo").toString() + "</visit_id>");
			extProps.put("visit_id", extProps.get("patHisNo").toString());
			extProps.remove("patHisNo");
		}
		if (extProps.get("patCardNo") != null) {
			builder.append("<patient_id>" + extProps.get("patCardNo").toString() + "</patient_id>");
			extProps.put("patient_id", extProps.get("patCardNo").toString());
			extProps.remove("patCardNo");
		}
		if (extProps.get("patientName") != null) {
			builder.append("<real_name>" + extProps.get("patientName").toString() + "</real_name>");
			extProps.put("real_name", extProps.get("patientName").toString());
			extProps.remove("patientName");
		}
		if (extProps.get("patientId") != null) {
			builder.append("<id_card>" + extProps.get("patientId").toString() + "</id_card>");
			extProps.put("id_card", extProps.get("patientId").toString());
			extProps.remove("patientId");
		}
		if (extProps.get("dataSrc") != null) {
			builder.append("<data_src>" + extProps.get("dataSrc").toString() + "</data_src>");
			extProps.put("data_src", extProps.get("dataSrc").toString());
			extProps.remove("dataSrc");
		}else {
			builder.append("<data_src>hisSrc</data_src>");
			extProps.put("data_src", "hisSrc");
			extProps.remove("dataSrc");
		}
		if (extProps.get("hisOrderNo") != null) {
			builder.append("<biz_id>" + extProps.get("hisOrderNo").toString() + "</biz_id>");
			extProps.put("biz_id", extProps.get("hisOrderNo").toString());
			extProps.remove("hisOrderNo");
		}
		if (extProps.get("payType") != null) {
			builder.append("<pay_type>" + extProps.get("payType").toString() + "</pay_type>");
			extProps.put("pay_type", extProps.get("payType").toString());
			extProps.remove("payType");
		}
		extProps.put("hospital_id", HOSPITALID);
		String buff = SignatureUtils.getSortContentO(extProps);
		buff = buff + KEY;
		logger.debug("发送:>>>>" + buff);
		String keyValue = MD5.MD5Encode(buff).toUpperCase();
		builder.append("<sign>" + keyValue + "</sign>");
		builder.append("</request>");
		logger.debug("CreateOppayOrderResultVo:request==>" + builder);
		// 接口地址
		//String address = "http://web.witontek.com/eHospital2/services/windowPayServiceV2?wsdl";
		String address = "http://ehospital.witontek.com/eHospital2/services/windowPayServiceV2?wsdl";
		// 代理工厂
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		// 设置代理地址
		jaxWsProxyFactoryBean.setAddress(address);
		// 设置接口类型
		jaxWsProxyFactoryBean.setServiceClass(IWindowPayWebServiceV2.class);
		// 创建一个代理接口实现
		IWindowPayWebServiceV2 cs = (IWindowPayWebServiceV2) jaxWsProxyFactoryBean.create();
		logger.info("createOppayOrder请求==> resultCode:{}" + builder.toString());
		String result = cs.createOrder(builder.toString());
		logger.info("CreateOppayOrderResultVo:response==>" + result);
		result = result.replaceAll("<data>", "");
		result = result.replaceAll("</data>", "");
		MarshallerUtil marshallerUtil = null;
		CreateOppayOrderResultVo createOppayOrderResultVo = new CreateOppayOrderResultVo();
		try {
			marshallerUtil = new MarshallerUtil("OppayService-createOppayOrder.xml", LoaderOppayService.class);
			createOppayOrderResultVo = (CreateOppayOrderResultVo) marshallerUtil.unMarshal(result);
			if("SUCCESS".equals(createOppayOrderResultVo.getResultCode())) {
				createOppayOrderResultVo.setResultCode("0");
			}
			logger.info("createOppayOrder返回==> tradeNo:{}" + createOppayOrderResultVo.getTradeNo());
			logger.info("createOppayOrder返回==> payUrl:{}" + createOppayOrderResultVo.getPayUrl());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误,请重试");
		}
		return createOppayOrderResultVo;
	}

	
	/**
	 * 
	 * @param hisId
	 * @param extProps
	 * @return
	 */
	public QryOppayOrderStatusResultVo qryOppayOrderStatus(Long hisId, Map<String, Object> extProps) {
		StringBuilder builder = new StringBuilder();
		builder.append("<request>");
	
		if (extProps.get("hospitalId") != null) {
			builder.append("<hospital_id>" + HOSPITALID + "</hospital_id>");
			extProps.put("hospital_id", HOSPITALID);
			extProps.remove("hospitalId");
		}
		if (extProps.get("tradeNo") != null) {
			builder.append("<trade_no>" + extProps.get("tradeNo").toString() + "</trade_no>");
			extProps.put("trade_no", extProps.get("tradeNo").toString());
			extProps.remove("tradeNo");
		}
		String buff = SignatureUtils.getSortContentO(extProps);
		buff = buff + KEY;
		logger.debug("发送:>>>>" + buff);
		String keyValue = MD5.MD5Encode(buff).toUpperCase();
		builder.append("<sign>" + keyValue + "</sign>");
		builder.append("</request>");
		logger.debug("qryOppayOrderStatusResultVo:request==>" + builder);
		// 接口地址
		//String address = "http://web.witontek.com/eHospital2/services/windowPayServiceV2?wsdl";
		String address = "http://ehospital.witontek.com/eHospital2/services/windowPayServiceV2?wsdl";
		// 代理工厂
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		// 设置代理地址
		jaxWsProxyFactoryBean.setAddress(address);
		// 设置接口类型
		jaxWsProxyFactoryBean.setServiceClass(IWindowPayWebServiceV2.class);
		// 创建一个代理接口实现
		IWindowPayWebServiceV2 cs = (IWindowPayWebServiceV2) jaxWsProxyFactoryBean.create();
		logger.info("qryOppayOrderStatusResultVo请求==> resultCode:{}" + builder.toString());
		String result = cs.qryOrderStatus(builder.toString());
		logger.info("qryOppayOrderStatusResultVo:response==>" + result);
		result = result.replaceAll("<data>", "");
		result = result.replaceAll("</data>", "");
		MarshallerUtil marshallerUtil = null;
		QryOppayOrderStatusResultVo qryOppayOrderStatusResultVo = new QryOppayOrderStatusResultVo();
		try {
			marshallerUtil = new MarshallerUtil("OppayService-qryOppayOrderStatus.xml", LoaderOppayService.class);
			qryOppayOrderStatusResultVo = (QryOppayOrderStatusResultVo) marshallerUtil.unMarshal(result);
			if("SUCCESS".equals(qryOppayOrderStatusResultVo.getResultCode())) {
				qryOppayOrderStatusResultVo.setResultCode("0");
			}
			logger.info("createOppayOrder返回==> tradeNo:{}" + qryOppayOrderStatusResultVo.getTradeNo());
			logger.info("createOppayOrder返回==> orderStatus:{}" + qryOppayOrderStatusResultVo.getOrderStatus());
		} catch (Exception e) {
			throw new HospitalException(HospitalException.HOSCENTER_SYSTEM_ERROR, "系统错误,请重试");
		}
		return qryOppayOrderStatusResultVo;
	}
	
	
	public HisOppayOrderVo checkOppayOrderMock(Long hisId, Map<String, Object> extProps) {
		HisOppayOrderVo hisOppayOrderVo = new HisOppayOrderVo();
		hisOppayOrderVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		hisOppayOrderVo.setDoctorId("1");
		hisOppayOrderVo.setDoctorName("2");
		hisOppayOrderVo.setDeptId("3");
		hisOppayOrderVo.setDeptName("4");
		hisOppayOrderVo.setHisId(1L);
		hisOppayOrderVo.setHisOrderNo("11111111");
		hisOppayOrderVo.setPatCardNo("5");
		hisOppayOrderVo.setPatientName("6");
		hisOppayOrderVo.setTotalFee(7);
		hisOppayOrderVo.setPatHisNo("8");
		return hisOppayOrderVo;
	}

	public List<HisOppayOrderVo> getHisOppayOrdersMock(Long hisId, Map<String, Object> extProps) {
		GetHisOppayOrderVo getHisOppayOrderVo = new GetHisOppayOrderVo();

		HisOppayOrderVo hisOppayOrderVo = new HisOppayOrderVo();
		hisOppayOrderVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		hisOppayOrderVo.setDoctorId("1");
		hisOppayOrderVo.setDoctorName("2");
		hisOppayOrderVo.setDeptId("3");
		hisOppayOrderVo.setDeptName("4");
		hisOppayOrderVo.setHisId(1L);
		hisOppayOrderVo.setHisOrderNo("11111111");
		hisOppayOrderVo.setPatCardNo("5");
		hisOppayOrderVo.setPatientName("6");
		hisOppayOrderVo.setTotalFee(7);
		hisOppayOrderVo.setPatHisNo("8");
		List<HisOppayOrderVo> itemList = new ArrayList<HisOppayOrderVo>();
		itemList.add(hisOppayOrderVo);
		getHisOppayOrderVo.setItemList(itemList);

		return getHisOppayOrderVo.getItemList();
	}

	public CreateOppayOrderResultVo createOppayOrderMock(Long hisId, Map<String, Object> extProps) {
		CreateOppayOrderResultVo createOppayOrderResultVo = new CreateOppayOrderResultVo();
		createOppayOrderResultVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		createOppayOrderResultVo.setHospitalId("1");
		createOppayOrderResultVo.setTradeNo("123456");
		createOppayOrderResultVo.setPayUrl("http://www.xxx.com/");
		return createOppayOrderResultVo;
	}

	public Oppayed2HisResultVo getHisOppayResultMock(Long hisId, Map<String, Object> extProps) {
		Oppayed2HisResultVo oppayed2HisResultVo = new Oppayed2HisResultVo();
		oppayed2HisResultVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		oppayed2HisResultVo.setHisSerialNo("123456");
		oppayed2HisResultVo.setHisRecepitNo("654321");
		return oppayed2HisResultVo;
	}

	public QryOppayOrderStatusResultVo qryOppayOrderStatusMock(Long hisId, Map<String, Object> extProps) {
		QryOppayOrderStatusResultVo qryOppayOrderStatusResultVo = new QryOppayOrderStatusResultVo();
		qryOppayOrderStatusResultVo.setResultCode(HosConstants.RETURN_CODE_SUCCESS);
		// 1:待支付; 2:已支付未通知 HIS; 3:退费中; 4:已退款; 5:支付失败; 6:支付中; 7:支付成功通知HIS失败; 9:支付成功通知HIS成功
		// 10:支付失败，11:订单关闭
		qryOppayOrderStatusResultVo.setOrderStatus("7");
		qryOppayOrderStatusResultVo.setFeeDate("2018-10-19");
		qryOppayOrderStatusResultVo.setId("123456");
		qryOppayOrderStatusResultVo.setTradeNo("123456");
		qryOppayOrderStatusResultVo.setOrderAmount("77");
		return qryOppayOrderStatusResultVo;
	}
}
