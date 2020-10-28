package com.nbteam.hislite.common.utils;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpMethod;

/**
 * 
 */
public interface HttpCallback {

    /**
     * callback when get response. if you need headers, httpMethod.getResponseHeaders()
     * 
     * @param httpMethod
     * @param cookies
     * @throws IOException
     */
    public void callback(int httpstatus, HttpMethod httpMethod, Cookie[] cookies) throws IOException;
}
