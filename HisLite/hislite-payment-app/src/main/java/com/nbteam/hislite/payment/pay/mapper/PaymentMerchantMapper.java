package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMerchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMerchantMapper {
    int deleteByPrimaryKey(Long insideMerchantId);

    int insert(PaymentMerchant record);

    int insertSelective(PaymentMerchant record);

    PaymentMerchant selectByPrimaryKey(Long insideMerchantId);

    int updateByPrimaryKeySelective(PaymentMerchant record);

    int updateByPrimaryKey(PaymentMerchant record);

    PaymentMerchant getPaymentMerchantByMode(@Param("hisId") Long hisId, @Param("bizChannel") String bizChannel,
                                             @Param("bizType") String bizType, @Param("payMode") String payMode);
}