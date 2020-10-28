package com.nbteam.hislite.payment.pay.mapper;

import com.nbteam.hislite.payment.api.pay.dto.PaymentOrder;
import com.nbteam.hislite.payment.api.pay.request.PaymentOrderParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentOrderMapper {
    int deleteByPrimaryKey(Long payOrderId);

    int insert(PaymentOrder record);

    int insertSelective(PaymentOrder record);

    PaymentOrder selectByPrimaryKey(Long payOrderId);

    int updateByPrimaryKeySelective(PaymentOrder record);

    int updateByPrimaryKey(PaymentOrder record);

    List<PaymentOrder> getPayOrders(PaymentOrderParam paramVo);
}