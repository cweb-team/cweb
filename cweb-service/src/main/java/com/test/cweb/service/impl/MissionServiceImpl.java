package com.test.cweb.service.impl;

import com.test.cweb.dao.interfaces.MissionDao;
import com.test.cweb.model.Mission;
import com.test.cweb.model.MissionExample;
import com.test.cweb.service.interfaces.IMissionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by feir4 on 2018/3/20.
 */
@Service
public class MissionServiceImpl implements IMissionService {

    private Logger logger = Logger.getLogger(MissionServiceImpl.class);

    @Resource
    MissionDao missionDao;

    @Override
    public Integer createMission(Mission mission) throws Exception {
        Integer missionId = null;
        if (null == mission) {
            logger.info("插入的任务不能为空");
            return null;
        }
        //TODO:获取新任务ID missionId
        mission.setPkId(missionId);
        int result = missionDao.insertSelective(mission);
        if (1 == result) {
            return missionId;
        } else {
            logger.info("插入不正确 mission: " + mission.toString());
            return null;
        }
    }

    @Override
    public void updateMission() throws Exception {

    }

    @Override
    public List<Mission> queryMissionList(Integer groupId, Integer type, Integer state) throws Exception {
        if (null == groupId || null == type || "".equals(type) || null == state) {
            logger.info("参数不能为空!");
            return null;
        }
        MissionExample missionExample = new MissionExample();
        MissionExample.Criteria criteria = missionExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId).andMissionTypeEqualTo(type).andStateEqualTo(state);
        missionExample.setOrderByClause("update_time desc");
        List<Mission> missionList = missionDao.selectByExample(missionExample);
        return missionList;
    }


    @Override
    public Mission queryMissionInfo(Integer missionId) throws Exception {
        if (null == missionId) {
            logger.info("参数不能为空!");
            return null;
        }
        Mission mission = missionDao.selectByPrimaryKey(missionId);
        return mission;
    }

    @Override
    public Integer modifyMissionState(Integer missionId, Integer state) throws Exception {
        if (null == missionId || null == state) {
            logger.info("参数不能为空!");
            return null;
        }
        int result = 0;
        Mission mission = missionDao.selectByPrimaryKey(missionId);
        if (null == mission) {
            logger.info("未查询到该任务: missionId = " + missionId);
            return null;
        } else {
            mission.setState(state);
            mission.setUpdateTime(new Date());
            result = missionDao.updateByPrimaryKey(mission);
        }
        return result;
    }
}