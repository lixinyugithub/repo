package com.nbteam.hislite.his.outpatient.mapper;

import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HisOppayOrderMapper {
    int deleteByPrimaryKey(Long oppayOrderId);

    int insert(HisOppayOrder record);

    int insertSelective(HisOppayOrder record);

    HisOppayOrder selectByPrimaryKey(Long oppayOrderId);

    int updateByPrimaryKeySelective(HisOppayOrder record);

    int updateByPrimaryKey(HisOppayOrder record);

    HisOppayOrder getOppayOrderByHisOrderNo(String hisOrderNo);
}