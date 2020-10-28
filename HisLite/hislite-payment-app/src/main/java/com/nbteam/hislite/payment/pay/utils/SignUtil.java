package com.nbteam.hislite.payment.pay.utils;

import com.nbteam.hislite.common.utils.MD5;
import com.nbteam.hislite.common.utils.XMLParser;
import com.nbteam.hislite.payment.api.common.constant.PaymentConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class SignUtil {
    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

    public static String getSign(Map<String, Object> map, String appSecret) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null && !"".equals(entry.getValue())) {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + appSecret;
        // Util.log("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        // Util.log("Sign Result:" + result);
        return result;
    }

    /**
     * 从API返回的XML数据里面重新计算一次签名
     * 
     * @param responseString API返回的XML数据
     * @return 新鲜出炉的签名
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static String getSignFromResponseString(String responseString, String appSecret)
            throws IOException, SAXException, ParserConfigurationException {
        Map<String, Object> map = XMLParser.getMapFromXML(responseString);
        // 清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign", "");
        // 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        return SignUtil.getSign(map, appSecret);
    }

    /**
     * 
     * 比较两个签名. <br/>
     * 
     * @param appSecret
     * @return
     */
    public static Boolean compareResultSign(String respXML, String appSecret) throws Exception {
        boolean flag = respXML.substring(respXML.indexOf("<return_code>"), respXML.indexOf("</return_code>"))
                .indexOf(PaymentConstants.RESULT_SUCCESS_CODE) > -1;
        if (flag && respXML.indexOf("sign") > -1) {
            Map<String, Object> map = XMLParser.getMapFromXML(respXML);
            String backSign = (String) map.get("sign");
            if (StringUtils.isBlank(backSign)) {
                return false;
            }
            map.put("sign", "");
            String newSign = SignUtil.getSign(map, appSecret);
            if (Objects.equals(backSign, newSign)) {
                return true;
            }
        }
        return true;
    }

    /**
     * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
     * 
     * @param responseString API返回的XML数据字符串
     * @return API签名是否合法
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkIsSignValidFromResponseString(String responseString, String appSecret)
            throws ParserConfigurationException, IOException, SAXException {

        Map<String, Object> map = XMLParser.getMapFromXML(responseString);
        logger.error(map.toString());

        String signFromAPIResponse = map.get("sign").toString();
        if (signFromAPIResponse == "" || signFromAPIResponse == null) {
            logger.error("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        logger.error("服务器回包里面的签名是:" + signFromAPIResponse);
        // 清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign", "");
        // 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String signForAPIResponse = SignUtil.getSign(map, appSecret);

        if (!signForAPIResponse.equals(signFromAPIResponse)) {
            // 签名验不过，表示这个API返回的数据有可能已经被篡改了
            logger.error("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
            return false;
        }
        logger.error("恭喜，API返回的数据签名验证通过!!!");
        return true;
    }
}
