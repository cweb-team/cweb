package com.test.cweb.service;

import com.test.cweb.model.Group;
import com.test.cweb.model.Team;
import com.test.cweb.model.result.ApiResult;

import java.util.HashMap;
import java.util.List;

/**
 * @author hyl
 * @date 2018/02/25
 */
public interface IGroupService {
    /**
     * 创建团队
     * @param group
     * @return
     */
    ApiResult addOneGroup(Group group);

    /**
     * 查找自己创建的团队
     * @return
     */
    ApiResult findGroupByLeaderId(int leaderId);

    /**
     * 查找所在团队
     * @param leaderId
     * @return
     */
    ApiResult findGroupByUserId(int leaderId);

    /**
     * 更新团队信息
     * @param group
     * @return
     */
    ApiResult updateGroup(Group group);

    /**
     * 根据团队Id查找团队
     * @param groupId
     * @return
     */
    Group findGroupByGroupId(int groupId);

    /**
     * 删除Group
     * @param groupId
     * @return
     */
    ApiResult deleteGroup(int groupId);
}
