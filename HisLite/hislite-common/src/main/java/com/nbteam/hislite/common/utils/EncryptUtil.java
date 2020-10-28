package com.nbteam.hislite.common.utils;
  
import java.security.MessageDigest;

import com.nbteam.hislite.common.constant.CommonConstants;
import org.springframework.util.Base64Utils;

public class EncryptUtil {  
    public static String getMD5(String inStr) {  
        MessageDigest md5 = null;  
        try {  
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(inStr.getBytes(CommonConstants.CHARSET_UTF8));
            return  Base64Utils.encodeToString(md5Bytes);
        } catch (Exception e) {
            return "";  
        } 
    }  
}  