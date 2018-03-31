package com.test.cweb.dao;

import com.test.cweb.model.ImgMissionLicense;
import com.test.cweb.model.ImgMissionLicenseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgMissionLicenseDao {
    long countByExample(ImgMissionLicenseExample example);

    int deleteByExample(ImgMissionLicenseExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(ImgMissionLicense record);

    int insertSelective(ImgMissionLicense record);

    List<ImgMissionLicense> selectByExample(ImgMissionLicenseExample example);

    ImgMissionLicense selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") ImgMissionLicense record, @Param("example") ImgMissionLicenseExample example);

    int updateByExample(@Param("record") ImgMissionLicense record, @Param("example") ImgMissionLicenseExample example);

    int updateByPrimaryKeySelective(ImgMissionLicense record);

    int updateByPrimaryKey(ImgMissionLicense record);
}