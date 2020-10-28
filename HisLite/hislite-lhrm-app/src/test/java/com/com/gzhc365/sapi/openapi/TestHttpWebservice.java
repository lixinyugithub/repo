package com.com.gzhc365.sapi.openapi;

import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.springframework.web.util.HtmlUtils;

public class TestHttpWebservice {
	public static void main(String[] args) {
		try {
			String result = remoteGetDate("http://220.170.195.141:3002/soap/IJhyyCal","findOutpatientPay","<RESQUEST><PATIENTCARD>900039958</PATIENTCARD><REALNAME>微信自助</REALNAME></RESQUEST>");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String remoteGetDate(String endpoint,String serviceName,String requestBody) throws Exception {
        int timeout = 60000;
        StringBuffer sb = new StringBuffer("");
        sb.append("<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:JhyyCalIntf-IJhyyCal\">");
        sb.append("<soapenv:Header/>");
        sb.append("<soapenv:Body>");
        sb.append("<urn:CallServer soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">");
        sb.append("<FUNC xsi:type=\"xsd:string\">"+serviceName+"</FUNC>");
        sb.append("<IN_XML xsi:type=\"xsd:string\">"+requestBody+"</IN_XML>");
        sb.append("</urn:CallServer>");
        sb.append("</soapenv:Body>");
        sb.append("</soapenv:Envelope>");
        try{
        // HttpClient发送SOAP请求
        System.out.println("HttpClient 发送SOAP请求");
        System.out.println("参数输出："+sb.toString());
        HttpClient client = new HttpClient();
      //设置用户名密码
        //client.getState().setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("SDICEAMUSER", "SDICEAMPASSWORD")); 
        PostMethod postMethod = new PostMethod(endpoint);
        // 设置连接超时
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 设置读取时间超时
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // 然后把Soap请求数据添加到PostMethod中
        RequestEntity requestEntity = new StringRequestEntity(sb.toString(), "text/xml", "UTF-8");
        //设置请求头部，否则可能会报 “no SOAPAction header” 的错误
        postMethod.setRequestHeader("SOAPAction","");
        // 设置请求体
        postMethod.setRequestEntity(requestEntity);
        int status = client.executeMethod(postMethod);
        // 打印请求状态码
        System.out.println("status:" + status);
        // 获取响应体输入流
        InputStream is = postMethod.getResponseBodyAsStream();
        // 获取请求结果字符串
        String result = IOUtils.toString(is);
        String value = HtmlUtils.htmlUnescape(result);
        System.out.println(value);
        int i = value.indexOf("<Response>");
        int j =  value.indexOf("</Response>");
        System.out.println(i+"::"+j);
        value = value.substring(i, j+11);
        System.out.println(value);
        return value;
     }catch(Exception se){
         throw new Exception("SOAP请求发送失败！");
     }
}
}
