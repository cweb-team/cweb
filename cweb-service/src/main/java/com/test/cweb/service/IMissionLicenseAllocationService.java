package com.test.cweb.service;

import com.test.cweb.model.MissionLicenseAllocation;

import java.util.List;

/**
 * @author zgh
 */
public interface IMissionLicenseAllocationService {

    /**
     * 根据missionId查询任务分配情况以及报名情况
     *
     * @param missionId 任务ID
     * @return List
     * @throws Exception
     * @author zgh
     */
    public List<MissionLicenseAllocation> queryAllocationByMissionId(Integer missionId) throws Exception;

    /**
     * 根据teamId查询任务分配情况以及报名情况
     *
     * @param teamId    分队ID
     * @return List
     * @throws Exception
     * @author zgh
     */
    public List<MissionLicenseAllocation> queryAllocationByTeamId(Integer teamId) throws Exception;

    /**
     * 任务名额分配
     *
     * @param missionLicenseAllocations 分配实例列表
     * @return Long 生成分配记录条数
     * @throws Exception
     * @author zgh
     */
    public Long insertAllocations(List<MissionLicenseAllocation> missionLicenseAllocations) throws Exception;
}
