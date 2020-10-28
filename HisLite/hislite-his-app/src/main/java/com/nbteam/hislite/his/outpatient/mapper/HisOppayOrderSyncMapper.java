package com.nbteam.hislite.his.outpatient.mapper;

import com.nbteam.hislite.his.api.outpatient.dto.HisOppayOrderSync;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HisOppayOrderSyncMapper {
    int deleteByPrimaryKey(Long syncId);

    int insert(HisOppayOrderSync record);

    int insertSelective(HisOppayOrderSync record);

    HisOppayOrderSync selectByPrimaryKey(Long syncId);

    int updateByPrimaryKeySelective(HisOppayOrderSync record);

    int updateByPrimaryKey(HisOppayOrderSync record);

    HisOppayOrderSync selectByCondition(@Param("orderId") Long orderId, @Param("objectId") Long objectId, @Param("system") String system, @Param("sendType") String sendType);
}