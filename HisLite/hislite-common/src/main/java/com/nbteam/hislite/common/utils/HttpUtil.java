package com.nbteam.hislite.common.utils;

import com.nbteam.hislite.common.enums.ErrorCodeEnum;
import com.nbteam.hislite.common.exception.BusinessException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/****
 * 
 * <pre>类名: HttpUtil</pre>
 * <pre>描述: http 请求发送，使用close</pre>
 */
public class HttpUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

	
	/***
	 * @Title: postData 
	 * @Description: 发送HTTP post 请求 
	 * @param 输入参数
	 * @return void返回类型 
	 * @throws
	 */
	public static byte[] postData(String url, String jsonData) {

		CloseableHttpClient client = createDefault(); // 创建默认连接
		CloseableHttpResponse res = null;
		byte[] byteArr = null;
		try {
			HttpPost post = new HttpPost(url);
			StringEntity s = new StringEntity(jsonData);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");// 发送json数据需要设置contentType
			post.setEntity(s);
			res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				byteArr = EntityUtils.toByteArray(entity);
		        EntityUtils.consume(entity);
				return byteArr;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(null == res){
					res.close();
				}
			} catch (IOException e) {
				LOG.error("关闭返回流失败",e);
			}
		}
		return null;
	}
	/***
	 * 
	* @Title: postDataStr 
	* @Description: 发送map形式的请求参数
	* @param   输入参数
	* @return String    返回类型 
	* @throws
	 */
	public static String postData(String url, Map<String, String> map) {
		return postData(url, map, null);
	}
	/***
	 * 
	* @Title: postDataStr 
	* @Description: files文件列表參數
	* @param   输入参数
	* @return String    返回类型 
	* @throws
	 */
	public static String postData(String url, Map<String, String> map,Map<String,byte[]> files) {
		// 请求配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
		// 参数配置请求构造
		List<NameValuePair> params = new ArrayList<NameValuePair>();        
        for (String key : map.keySet()) {
        	params.add(new BasicNameValuePair(key, map.get(key)));
        }
        //文件参数
        HttpEntity fileEntity = null;
        if(null != files && !files.isEmpty()){
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        	for (String key : files.keySet()) {
        		multipartEntityBuilder.addBinaryBody(key, files.get(key));
            }
            fileEntity = multipartEntityBuilder.build();
        }
        HttpUriRequest reqMethod = null;
        reqMethod = RequestBuilder.post().setUri(url)
        		.setEntity(fileEntity) //文件
                .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                .setConfig(requestConfig).build();
            
    	CloseableHttpClient client = createDefault(); // 创建默认连接
    	//发送请求
    	String retMesg = null;
		CloseableHttpResponse res = null;
		try {
			res = client.execute(reqMethod);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
				retMesg = EntityUtils.toString(entity, "UTF-8");
		        EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(null != res){
					res.close();
				}
			} catch (IOException e) {
				LOG.error("关闭返回流失败",e);
			}
		}
        return retMesg;
	  }
	
	public static String postDataStr(String url, String jsonData) {
		
		byte[]  responseByte = postData(url, jsonData);
		try {
			new String(responseByte,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOG.error("关闭返回流失败",e);
			throw new BusinessException(BusinessException.UNSUPPORTED_ENCODING, "不支持的编码");
		}
		return null;
	}
	/***
	 * 
	* @Title: createDefault 
	* @Description: http 请求
	* @param   输入参数
	* @return CloseableHttpClient    返回类型 
	* @throws
	 */
	public static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }
	
}
