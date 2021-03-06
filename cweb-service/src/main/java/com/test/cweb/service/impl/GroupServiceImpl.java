package com.test.cweb.service.impl;

import com.test.cweb.dao.GroupDao;
import com.test.cweb.model.Group;
import com.test.cweb.model.GroupExample;
import com.test.cweb.model.GroupExample.Criteria;
import com.test.cweb.model.Team;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author hyl
 * @date 2018/02/25
 */
@Service
public class GroupServiceImpl implements IGroupService {
    @Resource
    GroupDao groupDao;

    @Override
    public ApiResult addOneGroup(Group group){
        ApiResult apiResult = new ApiResult();

        int result = groupDao.insertSelective(group);

        if(result != 0) {
            apiResult.success(group);
        }else{
            apiResult.fail("创建失败");
        }

        return apiResult;
    }

    @Override
    public ApiResult findGroupByLeaderId(int leaderId){
        ApiResult apiResult = new ApiResult();
        GroupExample groupExample = new GroupExample();
        Criteria criteria = groupExample.createCriteria();
        criteria.andLeaderIdEqualTo(leaderId);
        List<Group> groups = groupDao.selectByExample(groupExample);
        if(groups.size() > 0){
            Group group = groups.get(0);
            apiResult.success(group);
        }else{
            apiResult.fail("无结果");
        }

        return apiResult;
    }

    @Override
    public ApiResult findGroupByUserId(int userId){
        ApiResult apiResult = new ApiResult();
        Group group = groupDao.selectByUserId(userId);
        if (group != null){
            apiResult.success(group);
        }else{
            apiResult.fail("无结果");
        }

        return apiResult;
    }

    @Override
    public ApiResult updateGroup(Group group){
        ApiResult apiResult = new ApiResult();
        int result = groupDao.updateByPrimaryKeySelective(group);
        if(result >0){
            Group resultGroup = groupDao.selectByPrimaryKey(group.getPkId());
            apiResult.success(resultGroup);
        }else{
            apiResult.fail();
        }
        return apiResult;
    }


    @Override
    public Group findGroupByGroupId(int groupId){
        Group group = groupDao.selectByPrimaryKey(groupId);
        return group;
    }

    @Override
    public ApiResult deleteGroup(int groupId){
        ApiResult apiResult = new ApiResult();
        int result = groupDao.deleteByPrimaryKey(groupId);
        if (result != 0){
            apiResult.success("成功解散");
        }else {
            apiResult.fail("解散失败");
        }
        return apiResult;
    }

}
