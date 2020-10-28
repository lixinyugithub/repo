package com.nbteam.hislite.hos.lhrm.service;

import com.nbteam.hislite.common.utils.JaxbUtil;
import com.nbteam.hislite.lhrm.api.outpatient.vo.FindClinicNoParamVo;
import com.nbteam.hislite.lhrm.api.outpatient.vo.FindClinicNoResultVo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: HosLhrmServiceTest
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2018-08-23 20:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HosLhrmServiceTest {

    @Test
    public void test1() {
        FindClinicNoParamVo book = new FindClinicNoParamVo();
        book.setRealName("test");
        book.setPatientCard("123123");
        String str = JaxbUtil.convertToXml(book);
        System.out.println(str);
    }


    /**
     * xml转bean测试.
     */
    @Test
    public void test2() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<findClinicNoResultVo><realName>yangwenxue</realName><patientCard>25</patientCard>"
                + "<clinicNo>123</clinicNo></findClinicNoResultVo>";
        FindClinicNoResultVo book = JaxbUtil.converyToJavaBean(str, FindClinicNoResultVo.class);
        System.out.println(book);
    }
}
