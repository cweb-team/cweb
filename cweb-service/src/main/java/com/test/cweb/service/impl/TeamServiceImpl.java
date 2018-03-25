package com.test.cweb.service.impl;

import com.test.cweb.dao.TeamDao;
import com.test.cweb.dao.UserGroupTeamDao;
import com.test.cweb.model.Team;
import com.test.cweb.model.TeamExample;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.ITeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hyl
 * @data 18/3/15 下午11:18
 */
@Service
public class TeamServiceImpl implements ITeamService {

    @Resource
    TeamDao teamDao;

    @Resource
    UserGroupTeamDao userGroupTeamDao;

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

    @Override
    public ApiResult deleteOneTeam(int teamId){
        ApiResult apiResult =new ApiResult();

        //1. 将usergroupteam表的team字段更新
        int result1 = userGroupTeamDao.updateTeamToNull(teamId);
        //2. 删除team表中的记录
        TeamExample teamExample = new TeamExample();
        TeamExample.Criteria criteria = teamExample.createCriteria();
        criteria.andPkIdEqualTo(teamId);

        int result2 = teamDao.deleteByExample(teamExample);

        if (result1 != 0 && result2 != 0){
            apiResult.success("删除成功");
        }else{
            apiResult.fail("删除失败");
        }

        return apiResult;
    }

    @Override
    public Team findOneTeam(int teamId){
        ApiResult apiResult = new ApiResult();
        Team team = teamDao.selectByPrimaryKey(teamId);


        return team;
    }

    @Override
    public ApiResult updateOneTeam(Team team){
        ApiResult apiResult = new ApiResult();
        int result =teamDao.updateByPrimaryKeySelective(team);
        if (result != 0){
            Team resultTeam = teamDao.selectByPrimaryKey(team.getPkId());
            apiResult.success(resultTeam);
        }else{
            apiResult.fail("更新失败");
        }
        return apiResult;
    }

}
