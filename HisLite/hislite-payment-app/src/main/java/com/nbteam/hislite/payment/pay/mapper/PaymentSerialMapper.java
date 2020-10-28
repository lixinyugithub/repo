package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentSerial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentSerialMapper {
    int deleteByPrimaryKey(Long paySerialId);

    int insert(PaymentSerial record);

    int insertSelective(PaymentSerial record);

    PaymentSerial selectByPrimaryKey(Long paySerialId);

    int updateByPrimaryKeySelective(PaymentSerial record);

    int updateByPrimaryKey(PaymentSerial record);

    PaymentSerial selectByMerchantOrderId(String merchantOrderId);

    List<PaymentSerial> selectByPayOrderId(Long payOrderId);
}