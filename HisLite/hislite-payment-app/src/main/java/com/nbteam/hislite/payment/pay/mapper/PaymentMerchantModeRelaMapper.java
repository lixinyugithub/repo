package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchantModeRela;
import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchantModeRelaKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMerchantModeRelaMapper {
    int deleteByPrimaryKey(PaymentMerchantModeRelaKey key);

    int insert(PaymentMerchantModeRela record);

    int insertSelective(PaymentMerchantModeRela record);

    PaymentMerchantModeRela selectByPrimaryKey(PaymentMerchantModeRelaKey key);

    int updateByPrimaryKeySelective(PaymentMerchantModeRela record);

    int updateByPrimaryKey(PaymentMerchantModeRela record);
}