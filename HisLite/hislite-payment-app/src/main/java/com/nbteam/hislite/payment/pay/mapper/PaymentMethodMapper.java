package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMethod;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMethodKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMethodMapper {
    int deleteByPrimaryKey(PaymentMethodKey key);

    int insert(PaymentMethod record);

    int insertSelective(PaymentMethod record);

    PaymentMethod selectByPrimaryKey(PaymentMethodKey key);

    int updateByPrimaryKeySelective(PaymentMethod record);

    int updateByPrimaryKey(PaymentMethod record);
}