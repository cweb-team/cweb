package com.test.cweb.dao;

import com.test.cweb.model.MissionLicenseAllocation;
import com.test.cweb.model.MissionLicenseAllocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MissionLicenseAlloctionDao {
    long countByExample(MissionLicenseAllocationExample example);

    int deleteByExample(MissionLicenseAllocationExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(MissionLicenseAllocation record);

    int insertSelective(MissionLicenseAllocation record);

    List<MissionLicenseAllocation> selectByExample(MissionLicenseAllocationExample example);

    MissionLicenseAllocation selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") MissionLicenseAllocation record, @Param("example") MissionLicenseAllocationExample example);

    int updateByExample(@Param("record") MissionLicenseAllocation record, @Param("example") MissionLicenseAllocationExample example);

    int updateByPrimaryKeySelective(MissionLicenseAllocation record);

    int updateByPrimaryKey(MissionLicenseAllocation record);
}