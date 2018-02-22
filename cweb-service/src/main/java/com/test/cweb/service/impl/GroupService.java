package com.test.cweb.service.impl;

import com.test.cweb.dao.GroupDao;
import com.test.cweb.model.Group;
import com.test.cweb.model.result.ApiResult;
import com.test.cweb.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class GroupService implements IGroupService {
    @Resource
    GroupDao groupDao;

    @Override
    public ApiResult addOne(Group group){
        ApiResult apiResult = new ApiResult();

        int result = groupDao.insertSelective(group);

        if(result != 0) {
            apiResult.success(group);
        }else{
            apiResult.fail("创建失败");
        }

        return apiResult;
    }
}
