package com.nbteam.hislite.his.inhospital.mapper;

import com.nbteam.hislite.his.api.inhospital.dto.HisInhospitalOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HisInhospitalOrderMapper {
    int deleteByPrimaryKey(Long inhospitalOrderId);

    int insert(HisInhospitalOrder record);

    int insertSelective(HisInhospitalOrder record);

    HisInhospitalOrder selectByPrimaryKey(Long inhospitalOrderId);

    int updateByPrimaryKeySelective(HisInhospitalOrder record);

    int updateByPrimaryKey(HisInhospitalOrder record);
}