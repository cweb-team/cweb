package com.test.cweb.service.impl;

import com.test.cweb.dao.UserGroupTeamDao;
import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.UserGroupTeamExample;
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
        List<UserGroupTeam> userGroupTeamList = userGroupTeamDao.selectByExample(userGroupTeamExample);
        return userGroupTeamList;

    }
}
