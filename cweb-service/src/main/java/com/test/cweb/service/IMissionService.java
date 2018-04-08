package com.test.cweb.service;

import com.test.cweb.model.Mission;

import java.util.List;

/**
 * @author zgh
 * @date 2018-3-18
 */
public interface IMissionService {

    /**
     * 新建任务
     * @param mission 任务实例
     * @return missionId 新任务Id
     * @author zgh
     * @date 2018-3-18
     */
    public Integer createMission(Mission mission) throws Exception;

    /**
     * 修改任务信息
     * @param mission   任务实例
     * @return 修改行数
     * @author zgh
     * @date 2018-3-18
     */
    public int updateMission(Mission mission) throws Exception;

    /**
     * 查询Mission列表
     *
     * @param groupId   团队Id
     * @param type      任务类型
     * @param state     任务状态
     * @return missionList
     * @author zgh
     */
    public List<Mission> queryMissionList(Integer groupId, Integer type, Integer state) throws Exception;

    /**
     * 查询单个Mission信息
     *
     * @param missionId 任务Id
     * @return mission
     * @author zgh
     */
    public Mission queryMissionInfo(Integer missionId) throws Exception;

    /**
     * 修改任务状态，如发布任务状态为1
     *
     * @param missionId 任务Id
     * @param state     任务状态
     * @return
     * @author zgh
     */
    public Integer modifyMissionState(Integer missionId, Integer state) throws Exception;

    /**
     * 删除任务
     *
     * @param missionId 任务ID
     * @return 删除记录数目
     * @throws Exception
     * @author zgh
     */
    public Integer deleteMission(Integer missionId) throws Exception;

    /**
     * 分配任务给分队
     *
     * @param missionId
     * @param groupId
     * @param allocation
     * @throws Exception
     */
    public void allocateMission(Integer missionId, Integer groupId, String allocation) throws Exception;
}
