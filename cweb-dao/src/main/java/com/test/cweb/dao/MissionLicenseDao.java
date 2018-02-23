package com.test.cweb.dao;

import com.test.cweb.model.MissionLicense;
import com.test.cweb.model.MissionLicenseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MissionLicenseDao {
    int countByExample(MissionLicenseExample example);

    int deleteByExample(MissionLicenseExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(MissionLicense record);

    int insertSelective(MissionLicense record);

    List<MissionLicense> selectByExample(MissionLicenseExample example);

    MissionLicense selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") MissionLicense record, @Param("example") MissionLicenseExample example);

    int updateByExample(@Param("record") MissionLicense record, @Param("example") MissionLicenseExample example);

    int updateByPrimaryKeySelective(MissionLicense record);

    int updateByPrimaryKey(MissionLicense record);
}