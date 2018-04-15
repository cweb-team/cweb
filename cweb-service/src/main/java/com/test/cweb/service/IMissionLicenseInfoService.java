package com.test.cweb.service;

import com.test.cweb.model.MissionLicenseInfo;

import java.util.List;

/**
 * @author zgh
 */
public interface IMissionLicenseInfoService {

    /**
     * 根据missionId查询报名任务的人员列表
     * @author zgh
     * @param missionId
     * @return
     */
    public List<MissionLicenseInfo> queryLicenseListByMissionId(Integer missionId) throws Exception;

    /**
     * 根据missionID和userID查询具体的任务情况
     *
     * @author zgh
     * @param missionId 任务ID
     * @param userId    用户ID
     * @return
     * @throws Exception
     */
    public MissionLicenseInfo queryLicenseByMissionIdUserId(Integer missionId, Integer userId) throws Exception;

    /**
     * 根据userID查询具体的任务情况
     *
     * @author myz
     * @param userId    用户ID
     * @return
     * @throws Exception
     */
    public List<MissionLicenseInfo> queryLicenseByUserId(Integer userId) throws Exception;

}
