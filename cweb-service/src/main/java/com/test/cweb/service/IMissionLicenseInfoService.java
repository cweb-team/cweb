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
    public List<MissionLicenseInfo> queryLicenseListByMissionId(Integer missionId);

}
