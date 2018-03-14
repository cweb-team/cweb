package com.test.cweb.service;

import com.test.cweb.model.Group;
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
    ApiResult addOne(Group group);

    /**
     * 查看所有团队
     * @return
     */
    ApiResult findAll();
}
