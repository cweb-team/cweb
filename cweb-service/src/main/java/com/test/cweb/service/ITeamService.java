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
}
