package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentMode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentModeMapper {
    int deleteByPrimaryKey(String payMode);

    int insert(PaymentMode record);

    int insertSelective(PaymentMode record);

    PaymentMode selectByPrimaryKey(String payMode);

    int updateByPrimaryKeySelective(PaymentMode record);

    int updateByPrimaryKey(PaymentMode record);

    PaymentMode getPaymentModeByChannel(@Param("payChannel") String payChannel, @Param("payMethod") String payMethod);

    List<PaymentMode> selectModeInfoList(@Param("hisId") Long hisId, @Param("bizChannel") String bizChannel,
        @Param("bizType") String bizType, @Param("payMethod") String payMethod, @Param("payChannel") String payChannel);
}