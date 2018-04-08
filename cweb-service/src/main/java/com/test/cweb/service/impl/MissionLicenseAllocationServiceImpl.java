package com.test.cweb.service.impl;

import com.test.cweb.dao.MissionLicenseAlloctionDao;
import com.test.cweb.model.MissionLicenseAllocation;
import com.test.cweb.model.MissionLicenseAllocationExample;
import com.test.cweb.service.IMissionLicenseAllocationService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by feir4 on 2018/4/7.
 */
@Service
public class MissionLicenseAllocationServiceImpl implements IMissionLicenseAllocationService {

    private Logger logger = Logger.getLogger(MissionLicenseAllocationServiceImpl.class);

    @Resource
    MissionLicenseAlloctionDao missionLicenseAlloctionDao;

    @Override
    public List<MissionLicenseAllocation> queryAllocationByMissionId(Integer missionId) throws Exception {
        MissionLicenseAllocationExample example = new MissionLicenseAllocationExample();
        example.createCriteria().andMissionIdEqualTo(missionId);
        return missionLicenseAlloctionDao.selectByExample(example);
    }

    @Override
    public List<MissionLicenseAllocation> queryAllocationByTeamId(Integer teamId) throws Exception {
        return null;
    }

    @Override
    public Long insertAllocations(List<MissionLicenseAllocation> missionLicenseAllocations) throws Exception {
        return null;
    }
}
