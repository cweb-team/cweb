package com.test.cweb.service.impl;

import com.test.cweb.dao.TeamDao;
import com.test.cweb.model.Team;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.ITeamService;

import javax.annotation.Resource;

/**
 * @author hyl
 * @data 18/3/15 下午11:18
 */
public class TeamServiceImpl implements ITeamService {

    @Resource
    TeamDao teamDao;

    @Override
    public ApiResult addOneTeam(Team team){
        ApiResult apiResult = new ApiResult();
        int result = teamDao.insertSelective(team);

        if(result !=0){
            apiResult.success();
        }else{
            apiResult.fail();
        }

        return apiResult;
    }
}
