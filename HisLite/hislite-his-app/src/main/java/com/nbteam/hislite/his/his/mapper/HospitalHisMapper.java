package com.nbteam.hislite.his.his.mapper;

import com.nbteam.hislite.his.api.his.dto.HospitalHis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalHisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HospitalHis record);

    int insertSelective(HospitalHis record);

    HospitalHis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HospitalHis record);

    int updateByPrimaryKeyWithBLOBs(HospitalHis record);

    int updateByPrimaryKey(HospitalHis record);
}