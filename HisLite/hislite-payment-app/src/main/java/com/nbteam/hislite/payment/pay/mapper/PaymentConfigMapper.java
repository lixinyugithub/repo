package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentConfigMapper {
    int deleteByPrimaryKey(Long configId);

    int insert(PaymentConfig record);

    int insertSelective(PaymentConfig record);

    PaymentConfig selectByPrimaryKey(Long configId);

    int updateByPrimaryKeySelective(PaymentConfig record);

    int updateByPrimaryKey(PaymentConfig record);
}