package com.test.cweb.dao;

import com.test.cweb.model.MissionLicenseInfo;
import com.test.cweb.model.MissionLicenseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MissionLicenseInfoDao {
    long countByExample(MissionLicenseInfoExample example);

    int deleteByExample(MissionLicenseInfoExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(MissionLicenseInfo record);

    int insertSelective(MissionLicenseInfo record);

    List<MissionLicenseInfo> selectByExample(MissionLicenseInfoExample example);

    MissionLicenseInfo selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") MissionLicenseInfo record, @Param("example") MissionLicenseInfoExample example);

    int updateByExample(@Param("record") MissionLicenseInfo record, @Param("example") MissionLicenseInfoExample example);

    int updateByPrimaryKeySelective(MissionLicenseInfo record);

    int updateByPrimaryKey(MissionLicenseInfo record);
}