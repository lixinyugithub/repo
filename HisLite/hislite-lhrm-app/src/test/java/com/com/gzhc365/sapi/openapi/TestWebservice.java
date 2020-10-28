package com.com.gzhc365.sapi.openapi;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//需要commons-io的jar包
import org.apache.commons.io.IOUtils;


public class TestWebservice {

	public static void main(String[] args) {
		try {
			soapSpecialConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void soapSpecialConnection() throws Exception {
		String s = new String();
		String ss = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:JhyyCalIntf-IJhyyCal\">" + 
				"   <soapenv:Header/>" + 
				"   <soapenv:Body>" + 
				"      <urn:CallServer soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" + 
				"         <FUNC xsi:type=\"xsd:string\">queryPatientInfo</FUNC>" + 
				"         <IN_XML xsi:type=\"xsd:string\">" + 
				"<resquest>" + 
				"  <patientCard>900039958</patientCard>" + 
				"</resquest>" + 
				"</IN_XML>" + 
				"      </urn:CallServer>" + 
				"   </soapenv:Body>" + 
				"</soapenv:Envelope>";
		
		// 设置soap请求报文的相关属性
		// url从soapUI的request1的RAW标签的POST获取，url中不要有空格
		String url = "http://220.170.195.141:3002/soap/IJhyyCal/HTTP/1.1";
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setDefaultUseCaches(false);
		// Host，Content-Type，SOAPAction从soapUI的request1的RAW标签的Host，Content-Typ，SOAPActione获取
		conn.setRequestProperty("Host", "220.170.195.141:3002");
		conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		conn.setRequestProperty("Content-Length", ss);
		conn.setRequestProperty("SOAPAction", "urn:JhyyCalIntf-IJhyyCal#CallServer");
		conn.setRequestMethod("POST");
		// 定义输出流
		System.out.println(ss);
		OutputStream output = conn.getOutputStream();
		if (null != ss) {
			byte[] b = ss.toString().getBytes("utf-8");
			// 发送soap请求报文
			output.write(b, 0, b.length);
		}
		output.flush();
		output.close();
		// 定义输入流，获取soap响应报文
		InputStream input = conn.getInputStream();
		// 需设置编码格式，否则会乱码
		s = IOUtils.toString(input, "UTF-8");
		input.close();
		System.out.println("返回的xml=" + s);
	}
}
