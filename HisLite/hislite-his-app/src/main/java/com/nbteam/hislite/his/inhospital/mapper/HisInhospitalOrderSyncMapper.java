package com.nbteam.hislite.his.inhospital.mapper;

import com.nbteam.hislite.his.api.inhospital.dto.HisInhospitalOrderSync;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HisInhospitalOrderSyncMapper {
    int deleteByPrimaryKey(Long inhospitalOrderSyncId);

    int insert(HisInhospitalOrderSync record);

    int insertSelective(HisInhospitalOrderSync record);

    HisInhospitalOrderSync selectByPrimaryKey(Long inhospitalOrderSyncId);

    int updateByPrimaryKeySelective(HisInhospitalOrderSync record);

    int updateByPrimaryKey(HisInhospitalOrderSync record);
}