package com.witontek.ehospital;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.nbteam.hislite.common.utils.MD5;
import com.nbteam.hislite.common.utils.SignatureUtils;


/**
 * @ClassName: TestWs
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2018-08-31 23:14
 */
public class TestWs {

    public static void main(String[] args) {
        try {
            // 接口地址
            String address = "http://web.witontek.com/eHospital2/services/miniPayServiceV2?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(IWindowPayWebServiceV2.class);
            // 创建一个代理接口实现
            IWindowPayWebServiceV2 cs = (IWindowPayWebServiceV2) jaxWsProxyFactoryBean.create();
            // 数据准备
            
            Map<String, String> parameters = new HashMap<>();
    		parameters.put("hospital_id", "lhxrmyyadmin");
    		parameters.put("totle_amt", "1");
    		parameters.put("visit_id", "1170700000001,1999900000840,1999900000914");
    		parameters.put("patient_id", "78kjh90jg909hvnjjkjk0997");
    		parameters.put("real_name", "曹四");
    		parameters.put("id_card", "320382198807013075");
    		parameters.put("data_src", "hisSrc");
    		parameters.put("biz_id", "123");
    		parameters.put("pay_type",  "wechatNo");
    		String buff = SignatureUtils.getSortContent(parameters);
    		System.out.println(buff);
    		buff = buff + "&key=dfe0061d1e52343ac06b88833d295af9";
    		
    		System.out.println(buff);
            String keyValue = MD5.MD5Encode(buff).toUpperCase();
            
            System.out.println(keyValue);
    		String userName = "<request><hospital_id>lhxrmyyadmin</hospital_id><totle_amt>1</totle_amt><visit_id>1170700000001,1999900000840,1999900000914</visit_id><patient_id>78kjh90jg909hvnjjkjk0997</patient_id><real_name>曹四</real_name><id_card>320382198807013075</id_card><data_src>hisSrc</data_src><biz_id>123</biz_id><pay_type>wechatNo</pay_type><sign>"+keyValue+"</sign></request>";
            // 调用代理接口的方法调用并返回结果
            System.out.println(userName);
            String result = cs.createOrder(userName);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
