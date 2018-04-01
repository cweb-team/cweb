package com.test.cweb.service.impl;

import com.test.cweb.dao.TeamDao;
import com.test.cweb.dao.UserGroupTeamDao;
import com.test.cweb.model.Team;
import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.UserGroupTeamExample;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IUserGroupTeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hyl
 * @data 18/3/24 上午10:09
 */
@Service
public class UserGroupTeamServiceImpl implements IUserGroupTeamService{

    @Resource
    UserGroupTeamDao userGroupTeamDao;

    @Resource
    TeamDao teamDao;

    @Override
    public UserGroupTeam findByUserId(int userId){
        UserGroupTeamExample userGroupTeamExample = new UserGroupTeamExample();
        UserGroupTeamExample.Criteria criteria = userGroupTeamExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserGroupTeam> userGroupTeamList = userGroupTeamDao.selectByExample(userGroupTeamExample);
        if(userGroupTeamList.size() >0){
            return userGroupTeamList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<UserGroupTeam> findAllMebmerByGroupId(int groupId) {
        UserGroupTeamExample userGroupTeamExample = new UserGroupTeamExample();
        UserGroupTeamExample.Criteria criteria = userGroupTeamExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        return userGroupTeamDao.selectByExample(userGroupTeamExample);


    }

    @Override
    public List<UserGroupTeam> findAllMemberByTeamId(int teamId) {
        UserGroupTeamExample userGroupTeamExample = new UserGroupTeamExample();
        UserGroupTeamExample.Criteria criteria = userGroupTeamExample.createCriteria();
        criteria.andTeamIdEqualTo(teamId);
        return userGroupTeamDao.selectByExample(userGroupTeamExample);

    }

    @Override
    public UserGroupTeam findByUserGroup(UserGroupTeam userGroupTeam) {
        UserGroupTeamExample userGroupTeamExample = new UserGroupTeamExample();
        UserGroupTeamExample.Criteria criteria = userGroupTeamExample.createCriteria();

        UserGroupTeam result = null;
        List<UserGroupTeam> userGroupTeamList = null;
        if (userGroupTeam.getUserId() != null){
            criteria.andUserIdEqualTo(userGroupTeam.getUserId());
        }else if(userGroupTeam.getTeamId() != null){
            criteria.andTeamIdEqualTo(userGroupTeam.getTeamId());
        }else if (userGroupTeam.getGroupId() != null){
            criteria.andGroupIdEqualTo(userGroupTeam.getGroupId());
        }
        userGroupTeamList = userGroupTeamDao.selectByExample(userGroupTeamExample);
        if (userGroupTeamList.size() > 0){
            result = userGroupTeamList.get(0);
            return result;
        }

        return null;
    }

    @Override
    public ApiResult addOneRecord(UserGroupTeam userGroupTeam) {
        ApiResult apiResult = new ApiResult();
        int result = userGroupTeamDao.insertSelective(userGroupTeam);
        if (result != 0){
            apiResult.success("添加成功");
        }else{
            apiResult.fail("添加失败");
        }
        return apiResult;
    }

    @Override
    public ApiResult updateOneRecord(UserGroupTeam userGroupTeam) {
        ApiResult apiResult = new ApiResult();
        int result = userGroupTeamDao.updateByPrimaryKeySelective(userGroupTeam);
        if (result != 0 ){
            apiResult.success("更新成功");
        }else{
            apiResult.fail("更新失败");
        }
        return apiResult;
    }

    @Override
    public ApiResult userJoinGroup(int userId, int groupId) {
        UserGroupTeam userGroupTeam = new UserGroupTeam();
        userGroupTeam.setUserId(userId);
        userGroupTeam.setGroupId(groupId);
        ApiResult apiResult = this.addOneRecord(userGroupTeam);
        return apiResult;
    }

    @Override
    public ApiResult userJoinTeam(int userId, int teamId) {
        ApiResult apiResult = new ApiResult();

        UserGroupTeamExample userGroupTeamExample = new UserGroupTeamExample();
        UserGroupTeamExample.Criteria criteria = userGroupTeamExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserGroupTeam> userGroupTeamList = userGroupTeamDao.selectByExample(userGroupTeamExample);
        Team team = teamDao.selectByPrimaryKey(teamId);
        int groupId = team.getGroupId();
        //1. 用户未加入团队
        if (userGroupTeamList.size() <= 0){
            UserGroupTeam userGroupTeam = new UserGroupTeam();
            userGroupTeam.setGroupId(groupId);
            userGroupTeam.setUserId(userId);
            userGroupTeam.setTeamId(teamId);
            apiResult = this.addOneRecord(userGroupTeam);
        }else { // 用户已加入团队
            UserGroupTeam userGroupTeam = userGroupTeamList.get(0);
            if (userGroupTeam.getGroupId().equals(groupId)){
                userGroupTeam.setTeamId(teamId);
                apiResult = this.updateOneRecord(userGroupTeam);
            }else {
                apiResult.fail();
            }
        }
        return apiResult
    }

}
