package com.nbteam.hislite.zuul.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;


public class ZuulAccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulAccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        return null;
    }

    /**
     * @throws IOException **
     * 
    * @Title: writeResponse 
    * @Description: 写入返回数据
    * @param   输入参数
    * @return void    返回类型 
    * @throws
     */
    private void writeResponse(HttpServletResponse servletResponse,String str) throws IOException{
		//设置编码
		servletResponse.setContentType("application/json; charset=utf-8");  
		OutputStream outStream = null;
		try {
			outStream = servletResponse.getOutputStream();
			outStream.write(str.getBytes(servletResponse.getCharacterEncoding()));
			outStream.flush();
		}finally {
			if(null != outStream){
				outStream.flush();
			}
		}
	}
    
   
}