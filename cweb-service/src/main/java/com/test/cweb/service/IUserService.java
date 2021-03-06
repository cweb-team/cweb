package com.test.cweb.service;

import com.test.cweb.model.User;
import com.test.cweb.model.UserGroupTeam;
import com.test.cweb.model.UserRole;
import com.test.cweb.model.result.ApiResult;

import java.util.List;
import java.util.Set;

/**
 * @author caiminjie
 * @date 18/2/1
 */

public interface IUserService {
    /**
     *test 1
     * @param name
     * @return
     */
    ApiResult findOne(String name);

    /**
     * test 2
     * @param name
     * @return
     */
    ApiResult findAll(String name);

    User findOneById(int userId);

    /**
     * 根据账号查询结果通过json返回
     * @param account
     * @return
     */
    ApiResult findByAccount(String account);

    /**
     * 根据账号查询结果返回User类
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 获得User对应的角色str集合
     * @param account
     * @return
     */
    Set<String> getRolesStr(String account);

    /**
     * 获得User对应的权限str集合
     * @param account
     * @return
     */
    Set<String> getPermissionsStr(String account);

    /**
     * 添加角色
     * @param userRole
     * @return
     */
    ApiResult addRole(UserRole userRole);

    /**
     * 移除角色
     * @param userRole
     * @return
     */
    ApiResult removeRole(UserRole userRole);

    /**
     * 小组信息更新
     * @param userGroupTeam
     * @return
     */
    ApiResult updateUserGroupTeam(UserGroupTeam userGroupTeam);


}
