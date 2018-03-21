package com.test.cweb.service;

import com.test.cweb.model.Team;
import com.test.cweb.model.result.ApiResult;

/**
 * @author hyl
 * @data 18/3/15 下午11:17
 */
public interface ITeamService {
    /**
     * 新增一个分队
     * @param team
     * @return
     */
    ApiResult addOneTeam(Team team);

    /**
     * 删除一个分队
     * @param teamId
     * @return
     */
    ApiResult deleteOneTeam(int teamId);

    /**
     * 查找一个分队
     * @param teamId
     * @return
     */
    Team findOneTeam(int teamId);

    /**
     * 更新分队信息
     * @param team
     * @return
     */
    ApiResult updateOneTeam(Team team);

}
