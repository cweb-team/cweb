package com.test.cweb.service;

import com.test.cweb.model.UserGroupTeam;

import java.util.List;

/**
 * @author hyl
 * @data 18/3/24 上午10:16
 */
public interface IUserGroupTeamService {
    /**
     * 根据用户Id查找关系
     * @param userId
     * @return
     */
    UserGroupTeam findByUserId(int userId);

    /**
     * 根据groupId查找所有的数据
     * @param groupId
     * @return
     */
    List<UserGroupTeam> findAllMebmerByGroupId(int groupId);

    /**
     * 查找用户团队小队关联信息
     * @param userGroupTeam
     * @return
     */
    UserGroupTeam findByUserGroup(UserGroupTeam userGroupTeam);
}
