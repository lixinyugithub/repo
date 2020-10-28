package com.nbteam.hislite.lhrm.common;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

import com.witontek.ehospital.IWindowPayWebServiceV2;

public class WebServiceUtil {

	private static final Logger LOG = LoggerFactory.getLogger(WebServiceUtil.class);

	/***
	 * @Title: postData @Description: 发送HTTP post 请求 @param 输入参数 @return
	 * void返回类型 @throws
	 */
	public static String sendWebService(String endpoint, String serviceName, String charset)
			throws ServiceException, MalformedURLException, RemoteException {
		// 创建一个服务（service）调用（call）
		Service service = new Service();
		Call call = (Call) service.createCall();
		// 设置service所在的url
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName(new QName("namespace", serviceName));
		return (String) call.invoke(new Object[] { charset });
	}

	/***
	 * @Title: postData @Description: 发送HTTP post 请求 @param 输入参数 @return
	 * void返回类型 @throws
	 */
	public static String remoteGetDate(String endpoint, String serviceName, String requestBody) {
		int timeout = 60000;
		StringBuffer sb = new StringBuffer("");
		sb.append(
				"<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:JhyyCalIntf-IJhyyCal\">");
		sb.append("<soapenv:Header/>");
		sb.append("<soapenv:Body>");
		sb.append("<urn:CallServer soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">");
		sb.append(" <FUNC xsi:type=\"xsd:string\">" + serviceName + "</FUNC>");
		sb.append("<IN_XML xsi:type=\"xsd:string\">" + requestBody + "</IN_XML>");
		sb.append("</urn:CallServer>");
		sb.append("</soapenv:Body>");
		sb.append("</soapenv:Envelope>");
		try {
			// HttpClient发送SOAP请求
			LOG.info("request:>>>"+sb.toString());
			HttpClient client = new HttpClient();
			PostMethod postMethod = new PostMethod(endpoint);
			// 设置连接超时
			client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
			// 设置读取时间超时
			client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
			// 然后把Soap请求数据添加到PostMethod中
			RequestEntity requestEntity = new StringRequestEntity(sb.toString(), "text/xml", "UTF-8");
			// 设置请求头部，否则可能会报 “no SOAPAction header” 的错误
			postMethod.setRequestHeader("SOAPAction", "");
			// 设置请求体
			postMethod.setRequestEntity(requestEntity);
			int status = client.executeMethod(postMethod);
			// 打印请求状态码
			LOG.info("status:>>>"+status);
			// 获取响应体输入流
			InputStream is = postMethod.getResponseBodyAsStream();
			// 获取请求结果字符串
			String result = IOUtils.toString(is);
			String value = HtmlUtils.htmlUnescape(result);
			int i = value.indexOf("<Response>");
			int j = value.indexOf("</Response>");
			value = value.substring(i, j + 11);
			LOG.info("response:>>>"+value);
			return value;
		} catch (Exception se) {
			return "";
		}
	}
}
