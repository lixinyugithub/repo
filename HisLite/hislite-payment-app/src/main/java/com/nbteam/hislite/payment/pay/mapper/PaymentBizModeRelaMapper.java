package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentBizModeRela;
import com.nbteam.hislite.payment.api.pay.dto.PaymentBizModeRelaKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentBizModeRelaMapper {
    int deleteByPrimaryKey(PaymentBizModeRelaKey key);

    int insert(PaymentBizModeRela record);

    int insertSelective(PaymentBizModeRela record);

    PaymentBizModeRela selectByPrimaryKey(PaymentBizModeRelaKey key);

    int updateByPrimaryKeySelective(PaymentBizModeRela record);

    int updateByPrimaryKey(PaymentBizModeRela record);
}