package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentSyncLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentSyncLogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(PaymentSyncLog record);

    int insertSelective(PaymentSyncLog record);

    PaymentSyncLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(PaymentSyncLog record);

    int updateByPrimaryKey(PaymentSyncLog record);
}