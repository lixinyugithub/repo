package com.nbteam.hislite.frame.config.gateway;

import com.nbteam.hislite.common.exception.BusinessException;
import com.nbteam.hislite.common.utils.HttpHelper;
import com.nbteam.hislite.common.utils.ResponseBodyCallback;
import com.nbteam.hislite.common.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.httpclient.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * 支付中心的网关服务<br/>
 *
 */
@Service
public class GateWayService {

    private static final Logger logger = LoggerFactory.getLogger(GateWayService.class);

    @Resource
    private HttpClientHelper httpClientHelper;

    public String post(String address, String charSet) {
        if (logger.isDebugEnabled()) {
            logger.debug(" 网关服务请求：{}", address);
        }
        if (StringUtils.isBlank(charSet)) {
            charSet = Utils.DEFAULT_CHARSET;
        }
        try {
            ResponseBodyCallback callback = new ResponseBodyCallback(charSet);
            int s = httpClientHelper.post(address, null, callback);
            if (s == 200) {
                return callback.getBody();
            } else {
                logger.error("调用POST请求状态错误，status:{},address:{}", s, address);
                throw new BusinessException(BusinessException.DEFAULT_CODE, "status code is" + s);
            }
        } catch (Exception e) {
            logger.error("网关服务请求异常", e);
            throw new BusinessException(BusinessException.DEFAULT_CODE, "支付网关请求异常");
        } finally {
            if (logger.isDebugEnabled()) {
                logger.debug("网关服务请求结束");
            }
        }
    }

    public String post(String address, String body, String reqCharSet, String respCharSet, String contentType) {
        if (logger.isDebugEnabled()) {
            logger.debug("网关请求：address:{}, body:{}", address, body);
        }
        try {
            if (StringUtils.isBlank(reqCharSet)) {
                reqCharSet = Utils.DEFAULT_CHARSET;
            }
            if (StringUtils.isBlank(respCharSet)) {
                respCharSet = Utils.DEFAULT_CHARSET;
            }
            ResponseBodyCallback callback = new ResponseBodyCallback(respCharSet);
            int s = httpClientHelper.post(address, body, reqCharSet, contentType, callback);
            if (s == 200) {
                return callback.getBody();
            } else {
                throw new BusinessException(BusinessException.DEFAULT_CODE, "status is" + s);
            }
        } catch (Exception e) {
            logger.error("请求网关异常", e);
            throw new BusinessException(BusinessException.DEFAULT_CODE, e.getLocalizedMessage());
        } finally {
            if (logger.isDebugEnabled()) {
                logger.debug("sequence:{}, 网关请求结束");
            }
        }
    }

    public String post(String address, String body, String soapAction) {
        try {
            Header[] headers = null;
            if (StringUtils.isNotBlank(soapAction)) {
                headers = new Header[] { new Header(HttpHelper.HEADER_NAME_CONTENT_TYPE, "text/xml;charset=UTF-8"),
                        new Header("SOAPAction", soapAction) };
            } else {
                headers = new Header[] { new Header(HttpHelper.HEADER_NAME_CONTENT_TYPE, "text/xml;charset=UTF-8") };
            }
            return post(address, body.getBytes(Utils.DEFAULT_CHARSET), Utils.DEFAULT_CHARSET, headers);
        } catch (Exception e) {
            logger.error("网关请求异常", e);
            throw new BusinessException(BusinessException.DEFAULT_CODE, e.getLocalizedMessage());
        } finally {
            if (logger.isDebugEnabled()) {
                logger.debug("网关请求结束 ");
            }
        }
    }

    private String post(String address, byte[] body, String charset, Header[] headers) {
        try {
            if (StringUtils.isBlank(charset)) {
                charset = Utils.DEFAULT_CHARSET;
            }
            ResponseBodyCallback callback = new ResponseBodyCallback(charset);
            int s = httpClientHelper.post(address, body, charset, null, headers, callback);
            if (s == 200) {
                return callback.getBody();
            } else {
                throw new BusinessException(BusinessException.DEFAULT_CODE, "status is" + s);
            }
        } catch (Exception e) {
            logger.error("网关请求异常", e);
            throw new BusinessException(BusinessException.DEFAULT_CODE, e.getLocalizedMessage());
        }
    }
}
