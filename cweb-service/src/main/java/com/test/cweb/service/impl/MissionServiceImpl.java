package com.test.cweb.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.test.cweb.dao.MissionDao;
import com.test.cweb.model.Mission;
import com.test.cweb.model.MissionExample;
import com.test.cweb.service.IMissionService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by feir4 on 2018/3/20.
 * @author zgh
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
        int result = missionDao.insertSelective(mission);
        if (1 == result) {
            missionId = mission.getPkId();
        }
        return missionId;
    }

    @Override
    public int updateMission(Mission mission) throws Exception {
        int result = 0;
        if (null == mission) {
            logger.info("参数不能为空");
            return result;
        }
        result = missionDao.updateByPrimaryKeySelective(mission);
        return result;
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

    @Override
    public Integer deleteMission(Integer missionId) throws Exception {
        Integer result = missionDao.deleteByPrimaryKey(missionId);
        return result;
    }


    private class Allocate{
        public String teamId;
        public String count;

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String name) {
            this.teamId = name;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String value) {
            this.count = value;
        }
    }
    private class AllocList{
        public List<Allocate> allocates;

        public List<Allocate> getAllocates() {
            return allocates;
        }

        public void setAllocates(List<Allocate> allocates) {
            this.allocates = allocates;
        }
    }

    @Override
    public void allocateMission(Integer missionId, Integer groupId, String allocation) throws Exception {
        JSONArray alloc = JSON.parseArray(allocation);
        List<Map> allocList = alloc.toJavaList(Map.class);
        System.out.println(allocList.toString());
    }

}
