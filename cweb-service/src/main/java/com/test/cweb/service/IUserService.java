package com.test.cweb.service;

import com.test.cweb.model.User;
import com.test.cweb.model.result.ApiResult;

import java.util.List;
import java.util.Set;

/**
 * @author caiminjie
 * @date 18/2/1
 */

public interface IUserService {
    ApiResult findOne(String name);
    ApiResult findAll(String name);
    User findByAccount(String account);
    Set<String> getRolesStr(String account);
    Set<String > getPermissionsStr(String account);
}
