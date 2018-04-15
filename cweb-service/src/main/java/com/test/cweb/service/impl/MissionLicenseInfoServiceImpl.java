package com.test.cweb.service.impl;

import com.test.cweb.dao.MissionLicenseInfoDao;
import com.test.cweb.model.MissionLicenseInfo;
import com.test.cweb.model.MissionLicenseInfoExample;
import com.test.cweb.service.IMissionLicenseInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by feir4 on 2018/3/23.
 */
@Service
public class MissionLicenseInfoServiceImpl implements IMissionLicenseInfoService {

    private Logger logger = Logger.getLogger(MissionLicenseInfoServiceImpl.class);

    @Resource
    MissionLicenseInfoDao missionLicenseInfoDao;

    @Override
    public List<MissionLicenseInfo> queryLicenseListByMissionId(Integer missionId) throws Exception{
        if (null == missionId) {
            logger.info("参数不能为空!");
            return null;
        }
        MissionLicenseInfoExample example = new MissionLicenseInfoExample();
        example.createCriteria().andMissionIdEqualTo(missionId);
        List<MissionLicenseInfo> infoList = missionLicenseInfoDao.selectByExample(example);
        return infoList;
    }

    @Override
    public MissionLicenseInfo queryLicenseByMissionIdUserId(Integer missionId, Integer userId) throws Exception {
        MissionLicenseInfoExample example = new MissionLicenseInfoExample();
        example.createCriteria().andMissionIdEqualTo(missionId).andUserIdEqualTo(userId);
        List<MissionLicenseInfo> licenseInfo = new ArrayList<>();
        licenseInfo = missionLicenseInfoDao.selectByExample(example);
        if (CollectionUtils.isEmpty(licenseInfo)) {
            return null;
        }
        return licenseInfo.get(1);
    }

    @Override
    public List <MissionLicenseInfo> queryLicenseByUserId(Integer userId) throws Exception {
        MissionLicenseInfoExample example = new MissionLicenseInfoExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<MissionLicenseInfo> licenseInfo = new ArrayList<>();
        licenseInfo = missionLicenseInfoDao.selectByExample(example);
        if (CollectionUtils.isEmpty(licenseInfo)) {
            return null;
        }
        return licenseInfo;
    }
}
