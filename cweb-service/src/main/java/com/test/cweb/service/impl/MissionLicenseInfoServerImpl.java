package com.test.cweb.service.impl;

import com.test.cweb.dao.interfaces.MissionLicenseInfoDao;
import com.test.cweb.model.MissionLicenseInfo;
import com.test.cweb.model.MissionLicenseInfoExample;
import com.test.cweb.service.interfaces.IMissionLicenseInfoServer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by feir4 on 2018/3/23.
 */
@Service
public class MissionLicenseInfoServerImpl implements IMissionLicenseInfoServer {

    private Logger logger = Logger.getLogger(MissionLicenseInfoServerImpl.class);

    @Resource
    MissionLicenseInfoDao missionLicenseInfoDao;

    @Override
    public List<MissionLicenseInfo> queryLicenseListByMissionId(Integer missionId) {
        if (null == missionId) {
            logger.info("参数不能为空!");
            return null;
        }
        MissionLicenseInfoExample example = new MissionLicenseInfoExample();
        example.createCriteria().andMissionIdEqualTo(missionId);
        List<MissionLicenseInfo> infoList = missionLicenseInfoDao.selectByExample(example);
        return infoList;
    }
}
