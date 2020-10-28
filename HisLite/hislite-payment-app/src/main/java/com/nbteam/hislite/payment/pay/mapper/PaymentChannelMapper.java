package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentChannel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentChannelMapper {
    int deleteByPrimaryKey(String payChannel);

    int insert(PaymentChannel record);

    int insertSelective(PaymentChannel record);

    PaymentChannel selectByPrimaryKey(String payChannel);

    int updateByPrimaryKeySelective(PaymentChannel record);

    int updateByPrimaryKey(PaymentChannel record);
}