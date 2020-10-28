package com.nbteam.hislite.lhrm.outpatient.mapper;

import com.nbteam.hislite.lhrm.api.outpatient.dto.HospitalOppayOrder;

public interface HospitalOppayOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HospitalOppayOrder record);

    int insertSelective(HospitalOppayOrder record);

    HospitalOppayOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HospitalOppayOrder record);

    int updateByPrimaryKey(HospitalOppayOrder record);
}